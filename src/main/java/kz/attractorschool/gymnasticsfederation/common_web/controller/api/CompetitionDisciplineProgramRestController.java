package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramDTO;
import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDisciplineProgram;
import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionProgram;
import kz.attractorschool.gymnasticsfederation.common_service.CompetitionDisciplineProgramsService;
import kz.attractorschool.gymnasticsfederation.common_service.CompetitionProgramService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines/programs")
@AllArgsConstructor
public class CompetitionDisciplineProgramRestController {
    private final CompetitionDisciplineProgramsService service;
    private final CompetitionProgramService competitionProgramService;

    @PostMapping
    public CompetitionDisciplineProgramDTO add(@Valid CompetitionDisciplineProgramAddDTO programsAddDTO) {
        return service.add(programsAddDTO);
    }

    @GetMapping("/all")
    public List<CompetitionDisciplineProgram> all() {
        return service.all();
    }

    @GetMapping("{id}")
    public List<CompetitionProgram> allByDisciplineTypeId(@PathVariable Integer id) {
        return competitionProgramService.allByDisciplineType(id);
    }


    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
