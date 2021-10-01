package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Discipline;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.DisciplineRepository;
import kz.attractorschool.gymnasticsfederation.common_service.AgeCategoryService;
import kz.attractorschool.gymnasticsfederation.common_service.CompetitionProgramService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineTypeService;
import kz.attractorschool.gymnasticsfederation.dto.DisciplineTypeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/competition/disciplines/types")
@AllArgsConstructor
public class CompetitionDisciplineTypeRestController {
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;
    private final DisciplineTypeService disciplineTypeService;
    private final DisciplineRepository disciplineRepository;

    @GetMapping("/{id}")
    public List<DisciplineTypeDTO> allByDisciplineId(@PathVariable Integer id) {
        Discipline discipline = disciplineRepository.getById(id);
        return discipline.getDisciplineTypes().stream().map(DisciplineTypeDTO::from).collect(Collectors.toList());
    }

    @GetMapping("/{id}/ages")
    public ResponseEntity<Object> allAgesByDisciplineType(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(ageCategoryService.allByDisciplineType(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/{id}/programs")
    public ResponseEntity<Object> allProgramsByDisciplineType(@PathVariable Integer id){
        try {
            return ResponseEntity.ok(competitionProgramService.allByDisciplineType(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
