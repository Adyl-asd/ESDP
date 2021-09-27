package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.dto.DisciplineDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.service.DisciplineService;
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
@RequestMapping("/disciplines")
public class DisciplineController {
    private final DisciplineService service;

    @GetMapping
    public String all(Model model){
        model.addAttribute("disciplines", service.all());
        return "disciplines/disciplines";
    }

    @PostMapping
    public String add(@Valid DisciplineDTO disciplineDTO,
                      BindingResult bindingResult,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("disciplineDTO", disciplineDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/disciplines";
        }
        service.add(disciplineDTO);
        return "redirect:/disciplines";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/disciplines";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("discipline", service.getOne(id));
        return "disciplines/discipline_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid DisciplineDTO disciplineDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("disciplineDTO", disciplineDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/disciplines/" + id + "/update";
        }
        service.update(disciplineDTO, id);
        return "redirect:/disciplines";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
