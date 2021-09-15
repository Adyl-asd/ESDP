package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgesAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgesDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramsAddDTO;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAges;
import kz.attractorschool.gymnasticsfederation.service.CompetitionDisciplineAgesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines/ages")
@AllArgsConstructor
public class CompetitionDisciplinesAgesRestController {
    private final CompetitionDisciplineAgesService service;

    @PostMapping
    public CompetitionDisciplineAgesDTO add(@Valid CompetitionDisciplineAgesAddDTO agesAddDTO,
                                            @Valid CompetitionDisciplineProgramsAddDTO programsAddDTO) {
        CompetitionDisciplineAgesDTO dto = service.add(agesAddDTO);
        return dto;
    }

    @GetMapping("/all")
    public List<CompetitionDisciplineAges> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public CompetitionDisciplineAges one(@PathVariable Integer id) {
        return service.findOne(id);
    }


    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
