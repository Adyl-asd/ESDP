package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgesAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramsAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramsDTO;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplinePrograms;
import kz.attractorschool.gymnasticsfederation.service.CompetitionDisciplineProgramsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines/programs")
@AllArgsConstructor
public class CompetitionDisciplinesProgramsRestController {
    private final CompetitionDisciplineProgramsService service;

    @PostMapping
    public CompetitionDisciplineProgramsDTO add(@Valid CompetitionDisciplineProgramsAddDTO programsAddDTO) {
        CompetitionDisciplineProgramsDTO dto = service.add(programsAddDTO);
        return dto;
    }

    @GetMapping("/all")
    public List<CompetitionDisciplinePrograms> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public CompetitionDisciplinePrograms one(@PathVariable Integer id) {
        return service.findOne(id);
    }


    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
