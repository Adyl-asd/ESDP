package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.dto.CoachCategoryDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_service.CoachCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/coach_categories")
public class CoachCategoryController {
    private final CoachCategoryService service;

    @GetMapping
    public String getCategoryList(Model model){
        model.addAttribute("categories", service.all());
        return "coach_category/coach_categories";
    }

    @PostMapping
    public String add(@Valid CoachCategoryDTO coachCategoryDTO,
                      BindingResult bindingResult,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("coachCategoryDTO", coachCategoryDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/coach_categories";
        }
        service.add(coachCategoryDTO);
        return "redirect:/coach_categories";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/coach_categories";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("category", service.getOne(id));
        return "coach_category/coach_category_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid CoachCategoryDTO coachCategoryDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("coachCategoryDTO", coachCategoryDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/coach_categories/" + id + "/update";
        }
        service.update(coachCategoryDTO, id);
        return "redirect:/coach_categories";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}
