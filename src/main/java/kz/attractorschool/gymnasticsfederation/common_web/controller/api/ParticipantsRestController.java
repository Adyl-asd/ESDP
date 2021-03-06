package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Coach;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Judge;
import kz.attractorschool.gymnasticsfederation.common_service.CoachService;
import kz.attractorschool.gymnasticsfederation.common_service.JudgeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ParticipantsRestController {
    private final CoachService coachService;
    private final JudgeService judgeService;

    @GetMapping("/{schoolId}/participants/coaches")
    public List<Coach> coachesBySchool(@PathVariable Integer schoolId){
        return coachService.allBySchoolId(schoolId);
    }

    @GetMapping("/{schoolId}/participants/judges/{disciplineId}")
    public List<Judge> judgesBySchool(@PathVariable Integer schoolId, @PathVariable Integer disciplineId){
        return judgeService.allBySchoolIdAndDisciplineId(schoolId, disciplineId);
    }
}
