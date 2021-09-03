package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.dto.RankDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.service.RankService;
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
@RequestMapping("/ranks")
public class RankController {
    private final RankService service;

    @GetMapping
    public String getRankList(Model model){
        model.addAttribute("ranks", service.all());
        return "rank/ranks";
    }

    @PostMapping
    public String add(@Valid RankDTO rankDTO,
                      BindingResult bindingResult,
                      RedirectAttributes attributes){
        attributes.addFlashAttribute("rankDTO", rankDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/ranks";
        }
        service.add(rankDTO);
        return "redirect:/ranks";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        service.delete(id);
        return "redirect:/ranks";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, Model model){
        model.addAttribute("rank", service.getOne(id));
        return "rank/rank_update";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Integer id,
                         @Valid RankDTO rankDTO,
                         BindingResult bindingResult,
                         RedirectAttributes attributes){
        attributes.addFlashAttribute("rankDTO", rankDTO);
        if (bindingResult.hasFieldErrors()){
            attributes.addFlashAttribute("errors", bindingResult.getFieldErrors());
            return "redirect:/ranks/" + id + "/update";
        }
        service.update(rankDTO, id);
        return "redirect:/ranks";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "resource-not-found";
    }
}
