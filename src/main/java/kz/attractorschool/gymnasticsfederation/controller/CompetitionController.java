package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/competitions")
public class CompetitionController {
    private final CompetitionService service;
    private final DisciplineService disciplineService;
    private final CompetitionDisciplineAgesService competitionDisciplineAgesService;
    private final CompetitionDisciplineProgramsService competitionDisciplineProgramsService;
    private final DisciplineTypeService disciplineTypeService;

    @GetMapping
    public String all(Model model){
        model.addAttribute("competitions", service.all());
        model.addAttribute("disciplines", disciplineService.all());
        return "competition/competitions";
    }

    @GetMapping("/{id}")
    public String getComp(@PathVariable Integer id,
                          Model model) {
        model.addAttribute("competition", service.findOne(id));
        model.addAttribute("disciplines", new HashSet<>(service.findOne(id).getDisciplineTypes()));
        model.addAttribute("competitionAges", competitionDisciplineAgesService.findByCompetitionId(id));
        model.addAttribute("competitionPrograms", competitionDisciplineProgramsService.findByCompetitionId(id));
        return "competition/competition";
    }

    @PostMapping("/{id}/confirm")
    public String confirm(@PathVariable Integer id){
        service.confirm(id);
        return "redirect:/competitions/" + id;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
