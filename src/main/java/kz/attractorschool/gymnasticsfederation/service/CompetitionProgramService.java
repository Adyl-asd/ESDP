package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.model.AgeCategory;
import kz.attractorschool.gymnasticsfederation.model.CompetitionProgram;
import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
