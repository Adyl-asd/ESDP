package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplinesAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplinesDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionDisciplinesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionDisciplinesService {

    private final CompetitionDisciplinesRepository repository;
    private final CompetitionService competitionService;
    private final DisciplineTypeService disciplineTypeService;
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;

    public List<CompetitionDisciplines> all() {
        return repository.findAll();
    }

    public CompetitionDisciplines findOne(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Соревнование", id);
        });
    }

    public CompetitionDisciplinesDTO add(CompetitionDisciplinesAddDTO dto) {
        Competition competition = competitionService.findOne(dto.getCompetitionId());
        DisciplineType disciplineType = disciplineTypeService.findOne(dto.getDisciplineTypeId());
        AgeCategory ageCategory = ageCategoryService.findOne(dto.getAgeCategoryId());
        CompetitionProgram competitionProgram = competitionProgramService.findOne(dto.getCompetitionProgramId());
        CompetitionDisciplines competitionDisciplines = repository.save(CompetitionDisciplines.builder()
                .competition(competition)
                .disciplineType(disciplineType)
                .ageCategory(ageCategory)
                .competitionProgram(competitionProgram)
                .build());
        return CompetitionDisciplinesDTO.from(competitionDisciplines);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }
}
