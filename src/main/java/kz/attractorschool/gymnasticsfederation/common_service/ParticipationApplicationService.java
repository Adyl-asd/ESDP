package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.common_data.repository.ParticipationApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationService {
    private final ParticipationApplicationRepository repository;
    private final SchoolService schoolService;
    private final CompetitionService competitionService;
    private final ParticipationApplicationAthleteService applicationAthleteService;
    private final ParticipationApplicationCoachService applicationCoachService;
    private final ParticipationApplicationJudgeService applicationJudgeService;

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

    public List<ParticipationApplication> allByCompetitionId(Integer id) {
        return repository.findAllByCompetitionId(id);
    }

    public ParticipationApplicationDTO add(int schoolId, int competitionId){
        if (repository.existsBySchoolIdAndCompetitionId(schoolId, competitionId)){
            return ParticipationApplicationDTO.from(repository.findBySchoolIdAndCompetitionId(schoolId, competitionId).orElseThrow(() -> {
                return new ResourceNotFoundException("Заявка", 0);
            }));
        }
        ParticipationApplication newApplication = repository.save(
                ParticipationApplication.builder()
                        .competition(competitionService.findOne(competitionId))
                        .school(schoolService.findOne(schoolId))
                        .build());
        return ParticipationApplicationDTO.from(newApplication);
    }


    public void delete(int id){
        ParticipationApplication application = findOne(id);
        applicationAthleteService.delete(application.getApplicationAthletes());
        applicationCoachService.delete(application.getApplicationCoaches());
        applicationJudgeService.delete(application.getApplicationJudges());
        repository.delete(findOne(id));
    }
}
