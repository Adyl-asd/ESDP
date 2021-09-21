package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.service.CompetitionService;
import kz.attractorschool.gymnasticsfederation.service.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/competitions")
public class CompetitionController {
    private final CompetitionService service;
    private final DisciplineService disciplineService;

    @GetMapping
    public String all(Model model){
        model.addAttribute("competitions", service.all());
        model.addAttribute("disciplines", disciplineService.all());
        return "competition/competitions";
    }
}
