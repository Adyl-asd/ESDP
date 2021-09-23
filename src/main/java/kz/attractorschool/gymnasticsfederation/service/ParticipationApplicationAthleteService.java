package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAthleteDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationAthleteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationAthleteService {
    private final ParticipationApplicationAthleteRepository repository;
    private final ParticipationApplicationService applicationService;
    private final AthleteService athleteService;
    private final CompetitionDisciplineAgesService agesService;

    public List<ParticipationApplicationAthlete> all(){
        return repository.findAll();
    }

    public ParticipationApplicationAthlete findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
    }

    public ParticipationApplicationAthleteDTO getOne(Integer id){
        return ParticipationApplicationAthleteDTO.from(findOne(id));
    }

    public ParticipationApplicationAthlete add(int applicationId, ParticipationApplicationAthleteAddDTO dto){
        ParticipationApplication application = applicationService.findOne(applicationId);
        if (repository.existsByApplicationIdAndAthleteIdAndDisciplineAgeId(applicationId, dto.getAthleteId(), dto.getDisciplineAgeId())){
            return repository.findByApplicationIdAndAthleteIdAndDisciplineAgeId(applicationId, dto.getAthleteId(), dto.getDisciplineAgeId()).orElseThrow(() -> {
                return new ResourceNotFoundException("Заявка", 0);
            });
        }
        ParticipationApplicationAthlete applicationAthlete = repository.save(
                ParticipationApplicationAthlete.builder()
                        .application(application)
                        .athlete(athleteService.findOne(dto.getAthleteId()))
                        .disciplineAge(agesService.findOne(dto.getDisciplineAgeId()))
                        .build());
        return applicationAthlete;
    }
}
