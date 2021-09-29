package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDisciplineDTO;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Competition;
import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDiscipline;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.CompetitionDisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionDisciplineService {

    private final CompetitionDisciplineRepository competitionDisciplineRepository;
    private final CompetitionService competitionService;
    private final DisciplineTypeService disciplineTypeService;

    public List<CompetitionDiscipline> all() {
        return competitionDisciplineRepository.findAll();
    }

    public List<CompetitionDiscipline> findByCompetitionId(Integer id) {
        return competitionDisciplineRepository.findAllByCompetitionId(id);
    }

    public CompetitionDiscipline findOne(Integer id) {
        return competitionDisciplineRepository.findById(id).orElseThrow();
    }

    public CompetitionDisciplineDTO add(CompetitionDisciplineAddDTO competitionDisciplineAddDTO) {
        Competition competition = competitionService.findOne(competitionDisciplineAddDTO.getCompetitionId());
        DisciplineType disciplineType = disciplineTypeService.findOne(competitionDisciplineAddDTO.getDisciplineTypeId());
        CompetitionDiscipline competitionDiscipline = competitionDisciplineRepository.save(CompetitionDiscipline.builder()
                .competition(competition)
                .discipline(disciplineType)
                .build()
        );
        return CompetitionDisciplineDTO.from(competitionDiscipline);
    }
}
