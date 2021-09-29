package kz.attractorschool.gymnasticsfederation.common_web.controller.main;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Competition;
import kz.attractorschool.gymnasticsfederation.common_service.*;
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
    private final ParticipationApplicationAthleteService applicationAthleteService;
    private final ParticipationApplicationCoachService applicationCoachService;
    private final ParticipationApplicationJudgeService applicationJudgeService;

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
        model.addAttribute("athletesCity", athleteService.findAllBySchoolAndDisciplineAndCityTeam(schoolId, competition.getDiscipline().getId()));
        model.addAttribute("athletesNational", athleteService.findAllBySchoolAndDisciplineAndNationalTeam(schoolId, competition.getDiscipline().getId()));
        model.addAttribute("coaches", coachService.allBySchoolAndDisciplineId(schoolId, competition.getDiscipline().getId()));
        model.addAttribute("judges", judgeService.allBySchoolAndDisciplineId(schoolId, competition.getDiscipline().getId()));
        model.addAttribute("application", service.add(schoolId, id));
        return "participation_application/participation_application_add";
    }

    @GetMapping("/all/{applicationId}")
    public String getOne(@PathVariable Integer id,@PathVariable Integer applicationId, Model model){
        model.addAttribute("competition", competitionService.findOne(id));
        model.addAttribute("disciplineTypes", competitionDisciplineService.findByCompetitionId(id));
        model.addAttribute("ageCategories", competitionDisciplineAgesService.findByCompetitionId(id));
        model.addAttribute("programs", competitionDisciplineProgramsService.findByCompetitionId(id));
        // После реализации функционала авторизации, нужно будет добавить логику на хранение id школы в пользователе и изменить запись ниже
        model.addAttribute("schools", schoolService.all());
        model.addAttribute("application", service.findOne(applicationId));
        model.addAttribute("athletes", applicationAthleteService.allByApplicationId(applicationId));
        return "participation_application/participation_application";
    }

    @GetMapping("/all")
    public String all(@PathVariable Integer id, Model model) {
        model.addAttribute("applications", service.allByCompetitionId(id));
        model.addAttribute("competition", competitionService.findOne(id));
        return "participation_application/participation_applications";
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
