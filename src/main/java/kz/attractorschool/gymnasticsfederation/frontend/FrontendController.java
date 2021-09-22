package kz.attractorschool.gymnasticsfederation.frontend;

import kz.attractorschool.gymnasticsfederation.enumm.CompetitionLevel;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class  FrontendController {

    private final DisciplineService disciplineService;
    private final AthleteService athleteService;
    private final JudgeCategoryService judgeCategoryService;
    private final CoachCategoryService coachCategoryService;
    private final RankService rankService;
    private final PersonService personService;
    private final DisciplineTypeService disciplineTypeService;
    private final CompetitionProgramService competitionProgramService;
    private final SchoolService schoolService;
    private final AgeCategoryService ageCategoryService;
    private final CompetitionService competitionService;
    private final CompetitionDisciplineAgesService competitionDisciplineAgesService;

    @GetMapping
    public String index() {
        return "index";
    }

//    @GetMapping("/disciplines")
//    public String getDisciplines(Model model) {
//        List<Discipline> disciplines = disciplineService.all();
//        model.addAttribute("disciplines", disciplines);
//        return "disciplines/disciplines";
//    }

    @GetMapping("/judges/categories")
    public String getJudgeCategories(Model model) {
        List<JudgeCategory> categories = judgeCategoryService.all();
        model.addAttribute("categories", categories);
        return "judge_category/judge_categories";
    }

    @GetMapping("/coaches/categories")
    public String getCoachCategories(Model model) {
        List<CoachCategory> categories = coachCategoryService.all();
        model.addAttribute("categories", categories);
        return "coach_category/coach_categories";
    }

    @GetMapping("/athletes/ranks")
    public String getRanks(Model model) {
        List<Rank> ranks = rankService.all();
        model.addAttribute("ranks", ranks);
        return "athlete_rank/ranks";
    }

    @GetMapping("/athletes")
    public String getAthletes(Model model) {
        List<Athlete> athletes = athleteService.all();
        List<Rank> ranks = rankService.all();
        List<Discipline> disciplines = disciplineService.all();
        model.addAttribute("athletes", athletes);
        model.addAttribute("ranks", ranks);
        model.addAttribute("disciplines", disciplines);
        return "athlete/athletes";
    }

    @GetMapping("/persons")
    public String persons(Model model){
        model.addAttribute("persons", personService.all());
        return "person/all";
    }

    @GetMapping("/competitions/add")
    public String getCompForm(Model model) {
        model.addAttribute("disciplines", disciplineService.all());
        model.addAttribute("disciplineTypes", disciplineTypeService.all());
        model.addAttribute("competitionPrograms", competitionProgramService.all());
        model.addAttribute("ranks", rankService.all());
        model.addAttribute("school", schoolService.findOne(1));
        model.addAttribute("ageCategories", ageCategoryService.all());
        model.addAttribute("levels", competitionService.getLevels());
        return "competition/competition_add";
    }

    @GetMapping("/test")
    public String test() {
        return "partials/templates";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    private String handleRNF(ResourceNotFoundException ex, Model model) {
        model.addAttribute("resource", ex.getResource());
        model.addAttribute("id", ex.getId());
        return "exception/resource-not-found";
    }
}
