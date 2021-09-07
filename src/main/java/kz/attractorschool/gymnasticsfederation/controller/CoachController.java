package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.files.*;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/coach")
public class CoachController {
    private final CoachService coachService;
    private final SchoolService schoolService;
    private final CoachCategoryService coachCategoryService;
    private final DisciplineService disciplineService;
    private final PersonService personService;
    private final FileSystemStorageService fileSystemStorageService;

    @GetMapping
    public String add(Model model) {
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("categories", coachCategoryService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("persons", personService.all());
        return "coach/coach_add";
    }

    @PostMapping
    public String add(@Valid CoachAddDTO coachAddDTO,
                      RedirectAttributes attributes,
                      BindingResult result,
                      @RequestParam("categoryFile") MultipartFile categoryFile) {
        attributes.addFlashAttribute("coachDTO", coachAddDTO);
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/coach";
        }
        if (!coachService.isPdf(categoryFile)) {
            attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
            return "redirect:/coach";
        }

        CoachCategoryFile coachCategoryFile = new CoachCategoryFile(categoryFile.getOriginalFilename());
        fileSystemStorageService.store(categoryFile);
        CoachDTO coachDTO = coachService.add(coachAddDTO, coachCategoryFile);
        return "redirect:/coach/" + coachDTO.getId();
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id,
                      Model model) {
        model.addAttribute("coach", coachService.findOne(id));
        return "coach/coach";
    }

    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("coaches", coachService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("categories", coachCategoryService.all());
        return "coach/coaches";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        coachService.delete(id);
        return "redirect:/coach";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         Model model) {
        model.addAttribute("coach", coachService.getOne(id));
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("categories", coachCategoryService.all());
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("persons", personService.all());
        model.addAttribute("coach", coachService.findOne(id));
        return "coach/coach_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid CoachUpdateDTO coachUpdateDTO,
                         RedirectAttributes attributes,
                         @RequestParam("categoryFile") MultipartFile categoryFile) {
        attributes.addFlashAttribute("coachDTO", coachUpdateDTO);
        if (categoryFile != null && !categoryFile.isEmpty()) {
            if (!coachService.isPdf(categoryFile)) {
                attributes.addFlashAttribute("filesError", "Все файлы должны быть в формате PDF");
                return "redirect:/coach";
            }
            CoachCategoryFile coachCategoryFile = new CoachCategoryFile(categoryFile.getOriginalFilename());
            fileSystemStorageService.store(categoryFile);
            coachService.updateFile(id, coachCategoryFile);
        }

       CoachDTO coachDTO = coachService.update(id, coachUpdateDTO);
        return "redirect:/coach/" + coachDTO.getId();
    }
}
