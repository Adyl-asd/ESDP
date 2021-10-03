package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.dto.FederationDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_service.FederationService;
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
@RequestMapping("/federation")
public class FederationController {
    private final FederationService service;

    @GetMapping
    public String add(){
        return "federation/federation_add";
    }

    @PostMapping
    public String add(@Valid FederationDTO federationDTO,
                      BindingResult bindingResult,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("federationDTO", federationDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/federation";
        }
        FederationDTO dto = service.add(federationDTO);
        return "redirect:/federation/" + dto.getId();
    }

    @GetMapping("/{id}")
    public String one(@PathVariable Integer id, Model model){
        model.addAttribute("federation", service.findOne(id));
        return "federation/federation";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/federation";
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("federations", service.all());
        return "federation/federations";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("federation", service.getOne(id));
        return "federation/federation_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid FederationDTO federationDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("federationDTO", federationDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/federation/" + id + "/update";
        }
        service.update(federationDTO, id);
        return "redirect:/federation/" + id;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
