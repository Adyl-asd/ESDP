package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationCoach;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationJudge;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationCoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationCoachService {
    private final ParticipationApplicationCoachRepository repository;
    private final ParticipationApplicationService applicationService;
    private final CoachService coachService;

    public List<ParticipationApplicationCoach> all(){
        return repository.findAll();
    }

    public ParticipationApplicationCoach findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
    }

    public ParticipationApplicationCoachDTO getOne(Integer id){
        return ParticipationApplicationCoachDTO.from(findOne(id));
    }

    public ParticipationApplicationCoachDTO add(int applicationId, ParticipationApplicationCoachAddDTO dto){
        ParticipationApplication application = applicationService.findOne(applicationId);
        if (repository.existsByApplicationIdAndCoachId(applicationId, dto.getCoachId())){
            return ParticipationApplicationCoachDTO.from(repository.findByApplicationIdAndCoachId(applicationId, dto.getCoachId()).orElseThrow(() -> {
                return new ResourceNotFoundException("Заявка", 0);
            }));
        }
        ParticipationApplicationCoach applicationCoach = repository.save(
                ParticipationApplicationCoach.builder()
                        .application(application)
                        .coach(coachService.findOne(dto.getCoachId()))
                        .build());
        return ParticipationApplicationCoachDTO.from(applicationCoach);
    }

    public void delete(int applicationId, int id){
        ParticipationApplicationCoach applicationCoach = repository.findByIdAndApplicationId(applicationId, id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
        repository.delete(applicationCoach);
    }
}
