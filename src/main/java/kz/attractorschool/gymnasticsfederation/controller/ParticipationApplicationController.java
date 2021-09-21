package kz.attractorschool.gymnasticsfederation.controller;

import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/competition/{id}")
public class ParticipationApplicationController {

    private final CompetitionService competitionService;
    private final CompetitionDisciplineService competitionDisciplineService;
    private final CompetitionDisciplineAgesService competitionDisciplineAgesService;
    private final CompetitionDisciplineProgramsService competitionDisciplineProgramsService;
    private final AthleteService athleteService;

    @GetMapping("/apply")
    public String getApplicationForm(@PathVariable Integer id,
                                     Model model) {
        model.addAttribute("competition", competitionService.findOne(id));
        model.addAttribute("disciplineTypes", competitionDisciplineService.findByCompetitionId(id));
        model.addAttribute("ageCategories", competitionDisciplineAgesService.findByCompetitionId(id));
        model.addAttribute("programs", competitionDisciplineProgramsService.findByCompetitionId(id));
        // После реализации функционала авторизации, нужно будет добавить логику на хранение id школы в пользователе и изменить запись ниже
        model.addAttribute("athletes", athleteService.findAllBySchoolId(competitionService.findOne(id).getSchool().getId()));
        return "participation_application/participation_application_add";
    }
}
