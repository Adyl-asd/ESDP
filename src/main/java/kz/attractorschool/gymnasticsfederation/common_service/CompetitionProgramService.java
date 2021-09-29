package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionProgram;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.CompetitionProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionProgramService {
    private final DisciplineTypeService disciplineTypeService;
    private final CompetitionProgramRepository competitionProgramRepository;

    public List<CompetitionProgram> all() {
        return competitionProgramRepository.findAll();
    }

    public CompetitionProgram findOne(Integer id) {
        return competitionProgramRepository.findById(id).orElseThrow();
    }

    public List<CompetitionProgram> allByDisciplineType(Integer id){
        DisciplineType discipline = disciplineTypeService.findOne(id);
        return discipline.getPrograms();
    }
}
