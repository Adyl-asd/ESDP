package kz.attractorschool.gymnasticsfederation.domain.frontend;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@AllArgsConstructor
public class FrontendController {

    @GetMapping
    public String index() {
        return "index";
    }
}
