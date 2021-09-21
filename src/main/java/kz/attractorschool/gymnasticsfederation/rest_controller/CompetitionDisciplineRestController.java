package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineDTO;
import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.service.CompetitionDisciplineService;
import kz.attractorschool.gymnasticsfederation.service.DisciplineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines")
@AllArgsConstructor
public class CompetitionDisciplineRestController {

    private final DisciplineService disciplineService;
    private final CompetitionDisciplineService competitionDisciplineService;

    @GetMapping
    public List<Discipline> all() {
        return disciplineService.all();
    }

    @GetMapping("/{id}")
    public Discipline one(@PathVariable Integer id) {
        return disciplineService.findOne(id);
    }

    @PostMapping
    public CompetitionDisciplineDTO add(@Valid CompetitionDisciplineAddDTO competitionDisciplineAddDTO) {
        return competitionDisciplineService.add(competitionDisciplineAddDTO);
    }
}
