package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineTypeService;
import kz.attractorschool.gymnasticsfederation.dto.DisciplineTypeAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.DisciplineTypeDTO;
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
@RequestMapping("/discipline_type")
public class DisciplineTypeController {
    private final DisciplineTypeService service;
    private final DisciplineService disciplineService;

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("discipline_types", service.all());
        model.addAttribute("disciplines", disciplineService.all());
        return "discipline_type/discipline_types";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("disciplines", disciplineService.all());
        return "discipline_type/discipline_type_add";
    }

    @PostMapping("/add")
    public String add(@Valid DisciplineTypeAddDTO dto,
                      BindingResult result,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("dto", dto);
        if (result.hasFieldErrors()){
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/discipline_type/add";
        }
        DisciplineTypeDTO typeDTO = service.add(dto);
        return "redirect:/discipline_type/" + typeDTO.getId();
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        DisciplineType disciplineType = service.delete(id);
        return "redirect:/discipline_type/all";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Integer id, Model model){
        model.addAttribute("discipline_type", service.findOne(id));
        return "discipline_type/discipline_type";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("discipline_type", service.getOne(id));
        model.addAttribute("disciplines", disciplineService.all());
        return "discipline_type/discipline_type_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id, DisciplineTypeAddDTO dto,
                         BindingResult result,
                         RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", dto);
        if (result.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", result.getFieldErrors());
            return "redirect:/discipline_type/" + id + "/update";
        }
        service.update(id, dto);
        return "redirect:/discipline_type/" + id;
    }

}
