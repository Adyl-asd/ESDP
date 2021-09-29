package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.dto.SchoolDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_service.FederationService;
import kz.attractorschool.gymnasticsfederation.common_service.SchoolService;
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
@RequestMapping("/school")
public class SchoolController {
    private final SchoolService service;
    private final FederationService federationService;

    @GetMapping
    public String add(Model model){
        model.addAttribute("federations", federationService.all());
        return "school/school_add";
    }

    @PostMapping
    public String add(@Valid SchoolDTO schoolDTO,
                      BindingResult bindingResult,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("schoolDTO", schoolDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/school";
        }
        SchoolDTO dto = service.add(schoolDTO);
        return "redirect:/school/" + dto.getId();
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id, Model model){
        model.addAttribute("school", service.getOne(id));
        return "school/school";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/school";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("school", service.getOne(id));
        return "school/school_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid SchoolDTO schoolDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("schoolDTO", schoolDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/school/" + id + "/update";
        }
        service.update(schoolDTO, id);
        return "redirect:/school/" + id;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
