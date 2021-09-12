package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionUpdateDTO;
import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/competition")
@AllArgsConstructor
public class CompetitionRestController {
    private final CompetitionService competitionService;
    private final FileSystemStorageService fileSystemStorageService;
    private final DisciplineService disciplineService;
    private final DisciplineTypeService disciplineTypeService;

    @GetMapping("/{id}")
    public Competition one(@PathVariable int id){
        return competitionService.findOne(id);
    }

    @GetMapping("/all")
    public List<Competition> all(){
        return competitionService.all();
    }

    @PostMapping
    public CompetitionDTO add(@Valid CompetitionAddDTO competitionAddDTO,
                              @RequestParam("competitionPositionFile")MultipartFile positionFile){
        CompetitionPositionFile pFile = new CompetitionPositionFile(positionFile.getOriginalFilename());
        fileSystemStorageService.store(positionFile);
        return competitionService.add(competitionAddDTO, pFile);
    }

    @PutMapping("/{id}/update")
    public CompetitionDTO update(@Valid CompetitionUpdateDTO competitionUpdateDTO,
                                 @PathVariable Integer id,
                                 @RequestParam("competitionPositionFile")MultipartFile positionFile) {
        CompetitionPositionFile pFile = new CompetitionPositionFile(positionFile.getOriginalFilename());
        fileSystemStorageService.store(positionFile);
        return competitionService.update(id, competitionUpdateDTO, pFile);
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        return competitionService.delete(id);
    }

//    @GetMapping("/competitions/{id}")
//    public ResponseEntity getCompetition(@PathVariable int id){
//        try {
//            return ResponseEntity.ok(service.getOne(id));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }
//
//    @GetMapping("/competitions")
//    public ResponseEntity getCompetitions(){
//        try {
//            return ResponseEntity.ok(service.getAll());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }

//    @GetMapping("/disciplines/{id}/disciplines_types")
//    public ResponseEntity getDisciplineTypes(@PathVariable int id){
//        try {
//            return ResponseEntity.ok(disciplineTypeService.getDisciplineTypesByDisciplineId(id));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }
//
//    @GetMapping("/disciplines")
//    public ResponseEntity getDisciplines(){
//        try {
//            return ResponseEntity.ok(disciplineService.getAll());
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }
//
//    @GetMapping("/disciplines/{id}")
//    public ResponseEntity getDisciplines(@PathVariable int id){
//        try {
//            return ResponseEntity.ok(disciplineService.getOne(id));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }

}
