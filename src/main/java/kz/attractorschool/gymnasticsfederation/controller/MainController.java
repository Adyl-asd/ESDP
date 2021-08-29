package kz.attractorschool.gymnasticsfederation.controller;

import com.example.esdp.ManRepository;
import com.example.esdp.model.Man;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    private final ManRepository repository;

    @GetMapping("/man")
    public String man(Model model){
        Man man = repository.findById(1).orElseThrow();
        model.addAttribute("man", man);
        return "man";
    }

    @GetMapping("/men")
    public String men(Model model){
        model.addAttribute("men", repository.findAll());
        return "men";
    }
}
