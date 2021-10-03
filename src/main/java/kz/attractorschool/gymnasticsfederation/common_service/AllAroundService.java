package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.common_data.entity.AllAround;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Competition;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.AllAroundRepository;
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
