package kz.attractorschool.gymnasticsfederation.frontend;

import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    DisciplineService disciplineService;
    JudgeCategoryService judgeCategoryService;
    CoachCategoryService coachCategoryService;
    RankService rankService;
    AthleteService athleteService;


    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/disciplines")
    public String getDisciplines(Model model) {
        List<Discipline> disciplines = disciplineService.all();
        model.addAttribute("disciplines", disciplines);
        return "disciplines/disciplines";
    }

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
        List<Discipline> disciplines = disciplineService.all();
        List<Rank> ranks = rankService.all();
        model.addAttribute("athletes", athletes);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("ranks", ranks);
        return "athlete/athletes";
    }
}
