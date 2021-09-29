package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationCoach;
import kz.attractorschool.gymnasticsfederation.common_data.repository.ParticipationApplicationCoachRepository;
import kz.attractorschool.gymnasticsfederation.common_data.repository.ParticipationApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationCoachService {
    private final ParticipationApplicationCoachRepository repository;
    private final ParticipationApplicationRepository applicationRepository;
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
        ParticipationApplication application = applicationRepository.findById(applicationId).orElseThrow(() ->{
            return new ResourceNotFoundException("Заявка", 0);
        });
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

    public void delete(List<ParticipationApplicationCoach> applicationCoaches){
        repository.deleteAll(applicationCoaches);
    }
}
