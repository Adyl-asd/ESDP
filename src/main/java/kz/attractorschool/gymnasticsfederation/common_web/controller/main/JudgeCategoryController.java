package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.dto.JudgeCategoryDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_service.JudgeCategoryService;
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
@RequestMapping("/judge_categories")
public class JudgeCategoryController {
    private final JudgeCategoryService service;

    @GetMapping
    public String all(Model model){
        model.addAttribute("categories", service.all());
        return "judge_category/judge_categories";
    }

    @PostMapping
    public String add(@Valid JudgeCategoryDTO judgeCategoryDTO,
                      BindingResult bindingResult,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("judgeCategoryDTO", judgeCategoryDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/judge_categories";
        }
        service.add(judgeCategoryDTO);
        return "redirect:/judge_categories";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/judge_categories";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("category", service.getOne(id));
        return "judge_category/judge_category_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid JudgeCategoryDTO judgeCategoryDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("judgeCategoryDTO", judgeCategoryDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/judge_categories/" + id + "/update";
        }
        service.update(judgeCategoryDTO, id);
        return "redirect:/judge_categories";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
