package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationAthleteDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import kz.attractorschool.gymnasticsfederation.repository.ParticipationApplicationAthleteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationAthleteService {
    private final ParticipationApplicationAthleteRepository repository;

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
}
