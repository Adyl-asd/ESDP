package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationService {
    private final ParticipationApplicationRepository repository;
    private final SchoolService schoolService;
    private final CompetitionService competitionService;

    public List<ParticipationApplication> all(){
        return repository.findAll();
    }

    public ParticipationApplication findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
    }

    public ParticipationApplicationDTO getOne(Integer id){
        return ParticipationApplicationDTO.from(findOne(id));
    }

    public ParticipationApplicationDTO add(int schoolId, int competitionId){
        ParticipationApplication application = repository.findBySchoolIdAndCompetitionId(schoolId, competitionId).orElse(null);
        if (application != null){
            return ParticipationApplicationDTO.from(application);
        }
        ParticipationApplication newApplication = repository.save(
                ParticipationApplication.builder()
                        .competition(competitionService.findOne(competitionId))
                        .school(schoolService.findOne(schoolId))
                        .build());
        return ParticipationApplicationDTO.from(newApplication);
    }
}
