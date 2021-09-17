package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.service.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines")
@AllArgsConstructor
public class CompetitionDisciplineRestController {

    private final DisciplineService disciplineService;

    @GetMapping
    public List<Discipline> all() {
        return disciplineService.all();
    }

    @GetMapping("/{id}")
    public Discipline one(@PathVariable Integer id) {
        return disciplineService.findOne(id);
    }
}
