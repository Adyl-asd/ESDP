package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.common_service.ParticipationApplicationCoachService;
import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationCoachAddDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/participation-application/coach")
public class ParticipationApplicationCoachRestController {
    private final ParticipationApplicationCoachService service;

    @PostMapping
    public void add(@Valid ParticipationApplicationCoachAddDTO dto) {
        service.add(dto);
    }
}
