package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.common_data.entity.AgeCategory;
import kz.attractorschool.gymnasticsfederation.common_service.AgeCategoryService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineTypeService;
import kz.attractorschool.gymnasticsfederation.common_service.RankService;
import kz.attractorschool.gymnasticsfederation.dto.AgeCategoryAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.AgeCategoryDTO;
import lombok.Getter;
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
import java.time.LocalDate;

@Controller
@RequestMapping("/age_category")
@RequiredArgsConstructor
public class AgeCategoriesController {
    private final AgeCategoryService service;
    private final DisciplineService disciplineService;
    private final DisciplineTypeService disciplineTypeService;
    private final RankService rankService;

    @GetMapping
    public String add(Model model){
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("ranks", rankService.all());
        return "age_category/age_category_add";
    }

    @PostMapping
    public String add(@Valid AgeCategoryAddDTO dto,
                      BindingResult result,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("dto", dto);
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/age_category";
        }
        else if((dto.getMinYear() == null && dto.getMaxYear() == null) ||
                (dto.getMinYear() > LocalDate.now().getYear() && dto.getMaxYear() > LocalDate.now().getYear())){
            attributes.addFlashAttribute("yearError", "Введите корректные значения в поля возраста");
            return "redirect:/age_category";
        }
        AgeCategory ageCategory = service.add(dto);
        return "redirect:/age_category/" + ageCategory.getId();
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("categories", service.all());
        model.addAttribute("disciplines", disciplineTypeService.all());
        return "age_category/age_categories";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Integer id, Model model){
        model.addAttribute("category", service.findOne(id));
        return "age_category/age_category";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/age_category/all";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("category", service.findOne(id));
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("ranks", rankService.all());
        return "age_category/age_category_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, @Valid AgeCategoryAddDTO dto,
                         BindingResult result,
                         RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", dto);
        if (result.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/age_category/" + id + "/update";
        }  else if((dto.getMinYear() == null && dto.getMaxYear() == null) ||
                (dto.getMinYear() > LocalDate.now().getYear() && dto.getMaxYear() > LocalDate.now().getYear())){
            attributes.addFlashAttribute("yearError", "Заполните хотя бы одно значение возраста");
            return "redirect:/age_category/" + id + "/update";
        }
        AgeCategory ageCategory = service.update(id, dto);
        return "redirect:/age_category/" + ageCategory.getId();
    }
}
