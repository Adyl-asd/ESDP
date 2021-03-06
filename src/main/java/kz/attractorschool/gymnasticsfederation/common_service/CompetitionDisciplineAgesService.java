package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.common_data.entity.AgeCategory;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Competition;
import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDisciplineAge;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAgeDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.repository.CompetitionDisciplineAgeRepository;
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
                .teamChampionship(dto.getTeamChampionship())
                .competition(competition)
                .discipline(disciplineType)
                .ageCategory(ageCategory)
                .maxTeams(dto.getMaxTeams())
                .maxAthletes(dto.getMaxAthletes())
                .build());
        return CompetitionDisciplineAgeDTO.from(competitionDisciplines);
    }

    public void delete (Integer id) {
        repository.deleteById(id);
    }


}
