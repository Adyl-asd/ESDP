package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramAddDTO;
import kz.attractorschool.gymnasticsfederation.model.AgeCategory;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAge;
import kz.attractorschool.gymnasticsfederation.service.AgeCategoryService;
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
    private final AgeCategoryService ageCategoryService;

    @PostMapping
    public CompetitionDisciplineAgeDTO add(@Valid CompetitionDisciplineAgeAddDTO agesAddDTO) {
        return service.add(agesAddDTO);
    }

    @GetMapping("/all")
    public List<CompetitionDisciplineAge> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public List<AgeCategory> allByDisciplineTypeId(@PathVariable Integer id) {
        return ageCategoryService.allByDisciplineType(id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
