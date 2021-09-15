package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramsAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramsDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionDisciplineProgramsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionDisciplineProgramsService {
    private final CompetitionDisciplineProgramsRepository repository;
    private final CompetitionService competitionService;
    private final DisciplineTypeService disciplineTypeService;
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;

    public List<CompetitionDisciplinePrograms> all() {
        return repository.findAll();
    }

    public CompetitionDisciplinePrograms findOne(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Соревнование", id);
        });
    }

    public List<CompetitionDisciplinePrograms> findByCompetitionId(Integer id) {
        return repository.findAllByCompetitionId(id);
    }

    public CompetitionDisciplineProgramsDTO add(CompetitionDisciplineProgramsAddDTO dto) {
        Competition competition = competitionService.findOne(dto.getCompetitionId());
        DisciplineType disciplineType = disciplineTypeService.findOne(dto.getDisciplineTypeId());
        CompetitionProgram competitionProgram = competitionProgramService.findOne(dto.getCompetitionProgramId());
        CompetitionDisciplinePrograms competitionDisciplines = repository.save(CompetitionDisciplinePrograms.builder()
                .competition(competition)
                .discipline(disciplineType)
                .competitionProgram(competitionProgram)
                .build());
        return CompetitionDisciplineProgramsDTO.from(competitionDisciplines);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }
}
