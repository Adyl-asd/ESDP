package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.common_service.CompetitionProgramService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineTypeService;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionProgramAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionProgramDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/competition_program")
public class CompetitionProgramController {
    private final CompetitionProgramService service;
    private final DisciplineTypeService disciplineTypeService;
    private final DisciplineService disciplineService;

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("programs", service.all());
        model.addAttribute("disciplines", disciplineTypeService.all());
        return "competition_program/competition_programs";
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("disciplines", disciplineService.all());
        return "competition_program/competition_program_add";
    }

    @PostMapping
    public String add(@Valid CompetitionProgramAddDTO dto,
                      BindingResult result,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("dto", dto);
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/competition_program";
        }
        CompetitionProgramDTO programDTO = service.add(dto);
        return "redirect:/competition_program/" + programDTO.getId();
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Integer id, Model model){
        model.addAttribute("program", service.findOne(id));
        return "competition_program/competition_program";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("program", service.findOne(id));
        model.addAttribute("disciplines", disciplineService.all());
        return "competition_program/competition_program_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid CompetitionProgramAddDTO dto,
                         BindingResult result,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("dto", dto);
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/competition_program/" + id + "/update";
        }
        CompetitionProgramDTO competitionProgramDTO = service.update(id, dto);
        return "redirect:/competition_program/" + competitionProgramDTO.getId();
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/competition_program/all";
    }
}
