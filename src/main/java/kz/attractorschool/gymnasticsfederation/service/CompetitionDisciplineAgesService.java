package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgesAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgesDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionDisciplineAgesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionDisciplineAgesService {

    private final CompetitionDisciplineAgesRepository repository;
    private final CompetitionService competitionService;
    private final DisciplineTypeService disciplineTypeService;
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;

    public List<CompetitionDisciplineAges> all() {
        return repository.findAll();
    }

    public CompetitionDisciplineAges findOne(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Соревнование", id);
        });
    }

    public List<CompetitionDisciplineAges> findByCompetitionId(Integer id) {
        return repository.findAllByCompetitionId(id);
    }

    public CompetitionDisciplineAgesDTO add(CompetitionDisciplineAgesAddDTO dto) {
        Competition competition = competitionService.findOne(dto.getCompetitionId());
        DisciplineType disciplineType = disciplineTypeService.findOne(dto.getDisciplineTypeId());
        AgeCategory ageCategory = ageCategoryService.findOne(dto.getAgeCategoryId());
        CompetitionDisciplineAges competitionDisciplines = repository.save(CompetitionDisciplineAges.builder()
                .competition(competition)
                .discipline(disciplineType)
                .ageCategory(ageCategory)
                .build());
        return CompetitionDisciplineAgesDTO.from(competitionDisciplines);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }
}
