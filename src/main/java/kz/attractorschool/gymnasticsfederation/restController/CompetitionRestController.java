package kz.attractorschool.gymnasticsfederation.restController;

import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CompetitionRestController {
    private final CompetitionService service;
    private final FileSystemStorageService fileSystemStorageService;
    private final DisciplineService disciplineService;
    private final DisciplineTypeService disciplineTypeService;

    @PostMapping
    public Competition createCompetition(@Valid Competition competition,
                                         @RequestParam("competitionPositionFile")MultipartFile positionFile){
        CompetitionPositionFile pFile = new CompetitionPositionFile(positionFile.getOriginalFilename());
        fileSystemStorageService.store(positionFile);
        return service.create(competition, pFile);
    }

    @GetMapping("/competitions/{id}")
    public ResponseEntity getCompetition(@PathVariable int id){
        try {
            return ResponseEntity.ok(service.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/competitions")
    public ResponseEntity getCompetitions(){
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/disciplines/{id}/disciplines_types")
    public ResponseEntity getDisciplineTypes(@PathVariable int id){
        try {
            return ResponseEntity.ok(disciplineTypeService.getDisciplineTypesByDisciplineId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/disciplines")
    public ResponseEntity getDisciplines(){
        try {
            return ResponseEntity.ok(disciplineService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity getDisciplines(@PathVariable int id){
        try {
            return ResponseEntity.ok(disciplineService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
