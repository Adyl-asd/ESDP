package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAddDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/competition/{id}")
public class ParticipationApplicationController {

    private final CompetitionService competitionService;
    private final CompetitionDisciplineService competitionDisciplineService;
    private final CompetitionDisciplineAgesService competitionDisciplineAgesService;
    private final CompetitionDisciplineProgramsService competitionDisciplineProgramsService;
    private final AthleteService athleteService;
    private final CoachService coachService;
    private final JudgeService judgeService;
    private final SchoolService schoolService;
    private final ParticipationApplicationService service;

    @GetMapping("/apply")
    public String getApplicationForm(@PathVariable Integer id,
                                     Model model) {
        Integer schoolId = 1;
        Competition competition = competitionService.findOne(id);
        model.addAttribute("competition", competition);
        model.addAttribute("disciplineTypes", competitionDisciplineService.findByCompetitionId(id));
        model.addAttribute("ageCategories", competitionDisciplineAgesService.findByCompetitionId(id));
        model.addAttribute("programs", competitionDisciplineProgramsService.findByCompetitionId(id));
        // После реализации функционала авторизации, нужно будет добавить логику на хранение id школы в пользователе и изменить запись ниже
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("athletes", athleteService.findAllBySchoolAndDisciplineId(schoolId, competition.getDiscipline().getId()));
        model.addAttribute("coaches", coachService.allBySchoolAndDisciplineId(schoolId, competition.getDiscipline().getId()));
        model.addAttribute("judges", judgeService.allBySchoolAndDisciplineId(schoolId, competition.getDiscipline().getId()));
        service.add(2, id);
        return "participation_application/participation_application_add";
    }

    @GetMapping("/apply/{applicationId}")
    public String getOne(@PathVariable Integer id,@PathVariable Integer applicationId, Model model){
        model.addAttribute("competition", competitionService.findOne(id));
        model.addAttribute("application", service.findOne(applicationId));
        return "participation_application/participation_application";
    }

    @PostMapping("/apply/{applicationId}")
    public String delete(@PathVariable Integer id,@PathVariable Integer applicationId){
        service.delete(applicationId);
        return "redirect:/competition/" + id;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
