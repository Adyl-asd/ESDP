package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationAthleteService;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationCoachService;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationJudgeService;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participation-application")
@AllArgsConstructor
public class ParticipationApplicationRestController {
    private final ParticipationApplicationCoachService applicationCoachService;
    private final ParticipationApplicationAthleteService applicationAthleteService;
    private final ParticipationApplicationJudgeService applicationJudgeService;

    @PostMapping("/{id}/athletes")
    public ParticipationApplicationAthlete addAthlete(@PathVariable Integer id, ParticipationApplicationAthleteAddDTO addDTO){
        ParticipationApplicationAthlete applicationAthlete = applicationAthleteService.add(id, addDTO);
        return applicationAthlete;
    }

    @DeleteMapping("/{applicationId}/athletes/{id}")
    public ResponseEntity deleteAthleteApplication(@PathVariable Integer applicationId, @PathVariable Integer id){
        applicationAthleteService.delete(applicationId, id);
        return ResponseEntity.ok("Заявка удалена");
    }

    @PostMapping("/{id}/coaches")
    public ResponseEntity addCoach(@PathVariable Integer id, ParticipationApplicationCoachAddDTO addDTO){
        ParticipationApplicationCoachDTO applicationCoach = applicationCoachService.add(id, addDTO);
        return ResponseEntity.ok(applicationCoach);
    }

    @DeleteMapping("/{applicationId}/coaches/{id}")
    public ResponseEntity deleteCoachApplication(@PathVariable Integer applicationId, @PathVariable Integer id){
        applicationCoachService.delete(applicationId, id);
        return ResponseEntity.ok("Заявка удалена");
    }

    @PostMapping("/{id}/judges")
    public ResponseEntity addJudge(@PathVariable Integer id, ParticipationApplicationJudgeAddDTO addDTO){
        ParticipationApplicationJudgeDTO applicationJudge = applicationJudgeService.add(id, addDTO);
        return ResponseEntity.ok(applicationJudge);
    }

    @DeleteMapping("/{applicationId}/judges/{id}")
    public ResponseEntity deleteJudgeApplication(@PathVariable Integer applicationId, @PathVariable Integer id){
        applicationJudgeService.delete(applicationId, id);
        return ResponseEntity.ok("Заявка удалена");
    }
}
