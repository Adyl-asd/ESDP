package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_service.AgeCategoryService;
import kz.attractorschool.gymnasticsfederation.common_service.CompetitionProgramService;
import kz.attractorschool.gymnasticsfederation.common_service.DisciplineTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/competition/disciplines/types")
@AllArgsConstructor
public class CompetitionDisciplineTypeRestController {
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;
    private final DisciplineTypeService disciplineTypeService;

    @GetMapping("{id}")
    public List<DisciplineType> allByDisciplineId(@PathVariable Integer id) {
        return disciplineTypeService.getAllByDisciplineId(id);
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
