package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionDisciplineAgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionDisciplineAgesService {

    private final CompetitionDisciplineAgeRepository repository;
    private final CompetitionService competitionService;
    private final DisciplineTypeService disciplineTypeService;
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;

    public List<CompetitionDisciplineAge> all() {
        return repository.findAll();
    }

    public CompetitionDisciplineAge findOne(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Соревнование", id);
        });
    }

    public List<CompetitionDisciplineAge> findByCompetitionId(Integer id) {
        return repository.findAllByCompetitionId(id);
    }

    public CompetitionDisciplineAgeDTO add(CompetitionDisciplineAgeAddDTO dto) {
        Competition competition = competitionService.findOne(dto.getCompetitionId());
        DisciplineType disciplineType = disciplineTypeService.findOne(dto.getDisciplineTypeId());
        AgeCategory ageCategory = ageCategoryService.findOne(dto.getAgeCategoryId());
        CompetitionDisciplineAge competitionDisciplines = repository.save(CompetitionDisciplineAge.builder()
                .competition(competition)
                .discipline(disciplineType)
                .ageCategory(ageCategory)
                .build());
        return CompetitionDisciplineAgeDTO.from(competitionDisciplines);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }
}
