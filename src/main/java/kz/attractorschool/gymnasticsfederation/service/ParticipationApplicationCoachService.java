package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationCoachDTO;
import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationJudgeDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
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
}
