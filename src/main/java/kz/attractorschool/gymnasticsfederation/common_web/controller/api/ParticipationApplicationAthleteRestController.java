package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.common_service.ParticipationApplicationAthleteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/participation-application/athlete")
public class ParticipationApplicationAthleteRestController {

    private final ParticipationApplicationAthleteService service;

    @PostMapping
    public void add(@Valid ParticipationApplicationAthleteAddDTO dto) {
        service.add(dto);
    }
}
