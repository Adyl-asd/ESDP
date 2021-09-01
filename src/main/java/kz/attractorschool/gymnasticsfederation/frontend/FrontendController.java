package kz.attractorschool.gymnasticsfederation.frontend;

import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.model.JudgeCategory;
import kz.attractorschool.gymnasticsfederation.service.DisciplineService;
import kz.attractorschool.gymnasticsfederation.service.JudgeCategoryService;
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
}
