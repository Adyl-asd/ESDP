package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramAddDTO;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAge;
import kz.attractorschool.gymnasticsfederation.service.CompetitionDisciplineAgesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines/ages")
@AllArgsConstructor
public class CompetitionDisciplineAgeRestController {
    private final CompetitionDisciplineAgesService service;

    @PostMapping
    public CompetitionDisciplineAgeDTO add(@Valid CompetitionDisciplineAgeAddDTO agesAddDTO,
                                           @Valid CompetitionDisciplineProgramAddDTO programsAddDTO) {
        CompetitionDisciplineAgeDTO dto = service.add(agesAddDTO);
        return dto;
    }

    @GetMapping("/all")
    public List<CompetitionDisciplineAge> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public CompetitionDisciplineAge one(@PathVariable Integer id) {
        return service.findOne(id);
    }


    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
