package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Athlete;
import kz.attractorschool.gymnasticsfederation.common_service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/athlete")
public class AthleteRestController {

    private final AthleteService athleteService;


    @GetMapping("/{id}")
    public List<Athlete> allBySchoolAndDisciplineId(@PathVariable Integer id, @RequestParam Integer schoolId, @RequestParam Integer disciplineId) {
        return athleteService.findAllBySchoolAndDisciplineAndAgeCategory(schoolId, disciplineId, id);
    }

}
