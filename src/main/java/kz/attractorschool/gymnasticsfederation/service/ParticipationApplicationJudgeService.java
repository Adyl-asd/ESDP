package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationJudgeDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationJudge;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationJudgeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationJudgeService {
    private final ParticipationApplicationJudgeRepository repository;

    public List<ParticipationApplicationJudge> all(){
        return repository.findAll();
    }

    public ParticipationApplicationJudge findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
    }

    public ParticipationApplicationJudgeDTO getOne(Integer id){
        return ParticipationApplicationJudgeDTO.from(findOne(id));
    }
}
