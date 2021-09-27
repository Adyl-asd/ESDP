package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.model.AllAround;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import kz.attractorschool.gymnasticsfederation.repository.AllAroundRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AllAroundService {
    private final AllAroundRepository repository;

    public AllAround add(Competition competition, DisciplineType discipline){
        return repository.save(AllAround.builder()
                    .competition(competition)
                    .discipline(discipline)
                    .build());
    }

    public void delete(Integer id){
        repository.delete(repository.findById(id).orElseThrow());
    }
}
