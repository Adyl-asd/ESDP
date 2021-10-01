package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineDTO;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Discipline;
import kz.attractorschool.gymnasticsfederation.common_service.CompetitionDisciplineService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineService;
import kz.attractorschool.gymnasticsfederation.dto.DisciplineDTO;
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
    public DisciplineDTO one(@PathVariable Integer id) {
        return disciplineService.getOne(id);
    }

    @PostMapping
    public CompetitionDisciplineDTO add(@Valid CompetitionDisciplineAddDTO competitionDisciplineAddDTO) {
        return competitionDisciplineService.add(competitionDisciplineAddDTO);
    }
}
