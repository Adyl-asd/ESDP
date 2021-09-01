package kz.attractorschool.gymnasticsfederation.frontend;

import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.service.DisciplineService;
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
}
