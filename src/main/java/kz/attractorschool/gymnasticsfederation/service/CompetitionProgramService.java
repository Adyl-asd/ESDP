package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.model.CompetitionProgram;
import kz.attractorschool.gymnasticsfederation.repository.CompetitionProgramRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionProgramService {

    private final CompetitionProgramRepository competitionProgramRepository;

    public List<CompetitionProgram> all() {
        return competitionProgramRepository.findAll();
    }
}
