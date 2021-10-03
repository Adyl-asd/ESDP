package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.common_service.ParticipationApplicationAthleteService;
import kz.attractorschool.gymnasticsfederation.common_service.ParticipationApplicationCoachService;
import kz.attractorschool.gymnasticsfederation.common_service.ParticipationApplicationJudgeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v")
@AllArgsConstructor
public class ParticipationApplicationRestController {
    private final ParticipationApplicationCoachService applicationCoachService;
    private final ParticipationApplicationAthleteService applicationAthleteService;
    private final ParticipationApplicationJudgeService applicationJudgeService;

//    @PostMapping("/{id}/athletes")
//    public ParticipationApplicationAthlete addAthlete(@PathVariable Integer id, ParticipationApplicationAthleteAddDTO addDTO){
//        ParticipationApplicationAthlete applicationAthlete = applicationAthleteService.add(id, addDTO);
//        return applicationAthlete;
//    }

    @DeleteMapping("/{applicationId}/athletes/{id}")
    public ResponseEntity deleteAthleteApplication(@PathVariable Integer applicationId, @PathVariable Integer id) {
        applicationAthleteService.delete(applicationId, id);
        return ResponseEntity.ok("Заявка удалена");
    }

//    @PostMapping("/{id}/coaches")
//    public ResponseEntity addCoach(@PathVariable Integer id, ParticipationApplicationCoachAddDTO addDTO) {
//        ParticipationApplicationCoachDTO applicationCoach = applicationCoachService.add(id, addDTO);
//        return ResponseEntity.ok(applicationCoach);
//    }

    @DeleteMapping("/{applicationId}/coaches/{id}")
    public ResponseEntity deleteCoachApplication(@PathVariable Integer applicationId, @PathVariable Integer id) {
        applicationCoachService.delete(applicationId, id);
        return ResponseEntity.ok("Заявка удалена");
    }

//    @PostMapping("/{id}/judges")
//    public ParticipationApplicationJudgeDTO addJudge(@PathVariable Integer id, ParticipationApplicationJudgeAddDTO addDTO) {
//        ParticipationApplicationJudgeDTO applicationJudge = applicationJudgeService.add(id, addDTO);
//        return applicationJudge;
//    }

    @DeleteMapping("/{applicationId}/judges/{id}")
    public ResponseEntity deleteJudgeApplication(@PathVariable Integer applicationId, @PathVariable Integer id) {
        applicationJudgeService.delete(applicationId, id);
        return ResponseEntity.ok("Заявка удалена");
    }
}
