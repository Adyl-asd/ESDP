package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplinesAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplinesDTO;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplines;
import kz.attractorschool.gymnasticsfederation.service.CompetitionDisciplinesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines")
@AllArgsConstructor
public class CompetitionDisciplinesRestController {

    private final CompetitionDisciplinesService service;

    @GetMapping("/all")
    public List<CompetitionDisciplines> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public CompetitionDisciplines one(@PathVariable Integer id) {
        return service.findOne(id);
    }

    @PostMapping
    public CompetitionDisciplinesDTO add(@Valid CompetitionDisciplinesAddDTO dto) {
        return service.add(dto);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
