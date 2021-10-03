package kz.attractorschool.gymnasticsfederation.common_web.controller.api;

import kz.attractorschool.gymnasticsfederation.common_service.ParticipationApplicationJudgeService;
import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationJudgeAddDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("api/participation-application/judge")
public class ParticipationApplicationJudgeRestController {
    private final ParticipationApplicationJudgeService service;

    @PostMapping
    public void add(@Valid ParticipationApplicationJudgeAddDTO dto) {
        service.add(dto);
    }
}
