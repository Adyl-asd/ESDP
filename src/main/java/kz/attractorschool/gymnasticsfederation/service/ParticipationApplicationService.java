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
}
