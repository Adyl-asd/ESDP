package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAthleteDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationAthleteRepository;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationAthleteService {
    private final ParticipationApplicationAthleteRepository repository;
    private final ParticipationApplicationRepository applicationRepository;
    private final AthleteService athleteService;
    private final CompetitionDisciplineAgesService agesService;
    private final DisciplineTypeService disciplineTypeService;
    private final DisciplineService disciplineService;

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

    public ParticipationApplicationAthlete add(ParticipationApplicationAthleteAddDTO dto){
        ParticipationApplication application = applicationRepository.findById(dto.getApplicationId()).orElseThrow(() ->{
            return new ResourceNotFoundException("Заявка", 0);
        });
        if (repository.existsByApplicationIdAndAthleteIdAndDisciplineAgeIdAndDisciplineTypeId(dto.getApplicationId(), dto.getAthleteId(), dto.getDisciplineAgeId(), dto.getDisciplineTypeId())){
            return repository.findByApplicationIdAndAthleteIdAndDisciplineAgeIdAndDisciplineTypeId(dto.getApplicationId(), dto.getAthleteId(), dto.getDisciplineAgeId(), dto.getDisciplineTypeId() ).orElseThrow(() -> {
                return new ResourceNotFoundException("Заявка", 0);
            });
        }
//        if (!isSameDiscipline(dto.getAthleteId(), application.getCompetition().getDiscipline().getId())){
//            return null;
//        }
        ParticipationApplicationAthlete applicationAthlete = repository.save(
                ParticipationApplicationAthlete.builder()
                        .application(application)
                        .athlete(athleteService.findOne(dto.getAthleteId()))
                        .disciplineAge(agesService.findOne(dto.getDisciplineAgeId()))
                        .disciplineType(disciplineTypeService.findOne(dto.getDisciplineTypeId()))
                        .build());
        return applicationAthlete;
    }

    public void delete(int applicationId, int id){
        ParticipationApplicationAthlete applicationAthlete = repository.findByIdAndApplicationId(applicationId, id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
        repository.delete(applicationAthlete);
    }

    public void delete(List<ParticipationApplicationAthlete> applicationAthletes){
        repository.deleteAll(applicationAthletes);
    }

    private boolean isSameDiscipline(int athleteId, int disciplineId){
        return athleteService.getOne(athleteId).getDiscipline().getId() == disciplineId;
    }

    private boolean isCorrectAge(int maxAge, int minAge, int athleteId){
        int year = athleteService.getOne(athleteId).getPerson().getBirthday().getYear();
        return year <= maxAge && year >= minAge;
    }

    private boolean isCorrectAge(int maxAge, int athleteId){
        int year = athleteService.getOne(athleteId).getPerson().getBirthday().getYear();
        return year <= maxAge;
    }

//    private boolean isCorrectAge(int minAge, int athleteId){
//        int year = athleteService.getOne(athleteId).getPerson().getBirthday().getYear();
//        return year >= minAge;
//    }
}
