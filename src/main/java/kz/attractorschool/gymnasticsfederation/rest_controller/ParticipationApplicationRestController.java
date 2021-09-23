package kz.attractorschool.gymnasticsfederation.rest_controller;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationAthleteRepository;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationCoachRepository;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationJudgeRepository;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationAthleteService;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationCoachService;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationJudgeService;
import kz.attractorschool.gymnasticsfederation.service.ParticipationApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/participation-application")
@AllArgsConstructor
public class ParticipationApplicationRestController {
    private final ParticipationApplicationCoachService applicationCoachService;
    private final ParticipationApplicationAthleteService applicationAthleteService;
    private final ParticipationApplicationJudgeService applicationJudgeService;
    private final ParticipationApplicationService applicationService;

    @PostMapping("/{id}/athletes")
    public ResponseEntity addAthlete(@PathVariable Integer id, ParticipationApplicationAthleteAddDTO addDTO){
        ParticipationApplicationAthlete applicationAthlete = applicationAthleteService.add(id, addDTO);
        return ResponseEntity.ok(applicationAthlete);
    }

    @PostMapping("/{id}/coaches")
    public ResponseEntity addCoach(@PathVariable Integer id, ParticipationApplicationCoachAddDTO addDTO){
        ParticipationApplicationCoachDTO applicationCoach = applicationCoachService.add(id, addDTO);
        return ResponseEntity.ok(applicationCoach);
    }

    @PostMapping("/{id}/judges")
    public ResponseEntity addJudge(@PathVariable Integer id, ParticipationApplicationJudgeAddDTO addDTO){
        ParticipationApplicationJudgeDTO applicationJudge = applicationJudgeService.add(id, addDTO);
        return ResponseEntity.ok(applicationJudge);
    }
}
