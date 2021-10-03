package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionProgram;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.CompetitionProgramRepository;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionProgramAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionProgramDTO;
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

    public CompetitionProgramDTO add(CompetitionProgramAddDTO dto){
        DisciplineType disciplineType = disciplineTypeService.findOne(dto.getDisciplineTypeId());
        CompetitionProgram competitionProgram = competitionProgramRepository.save(CompetitionProgram.builder()
                        .discipline(disciplineType)
                        .name(dto.getName())
                        .build());
        return CompetitionProgramDTO.from(competitionProgram);
    }

    public CompetitionProgramDTO update(int id, CompetitionProgramAddDTO dto){
        CompetitionProgram competitionProgram = findOne(id);
        competitionProgram.setDiscipline(disciplineTypeService.findOne(dto.getDisciplineTypeId()));
        competitionProgram.setName(dto.getName());
        competitionProgramRepository.save(competitionProgram);
        return CompetitionProgramDTO.from(competitionProgram);
    }

    public void delete(int id){
        CompetitionProgram competitionProgram = findOne(id);
        competitionProgram.setDel(true);
        competitionProgramRepository.save(competitionProgram);
    }
}
