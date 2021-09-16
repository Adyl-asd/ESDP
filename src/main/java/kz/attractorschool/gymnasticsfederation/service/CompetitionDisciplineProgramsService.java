package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineProgramDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionDisciplineProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionDisciplineProgramsService {
    private final CompetitionDisciplineProgramRepository repository;
    private final CompetitionService competitionService;
    private final DisciplineTypeService disciplineTypeService;
    private final AgeCategoryService ageCategoryService;
    private final CompetitionProgramService competitionProgramService;

    public List<CompetitionDisciplineProgram> all() {
        return repository.findAll();
    }

    public CompetitionDisciplineProgram findOne(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Соревнование", id);
        });
    }

    public List<CompetitionDisciplineProgram> findByCompetitionId(Integer id) {
        return repository.findAllByCompetitionId(id);
    }

    public CompetitionDisciplineProgramDTO add(CompetitionDisciplineProgramAddDTO dto) {
        Competition competition = competitionService.findOne(dto.getCompetitionId());
        DisciplineType disciplineType = disciplineTypeService.findOne(dto.getDisciplineTypeId());
        CompetitionProgram competitionProgram = competitionProgramService.findOne(dto.getCompetitionProgramId());
        CompetitionDisciplineProgram competitionDisciplines = repository.save(CompetitionDisciplineProgram.builder()
                .competition(competition)
                .discipline(disciplineType)
                .competitionProgram(competitionProgram)
                .build());
        return CompetitionDisciplineProgramDTO.from(competitionDisciplines);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }
}
