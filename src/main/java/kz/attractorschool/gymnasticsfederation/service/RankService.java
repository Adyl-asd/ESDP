package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.Rank;
import kz.attractorschool.gymnasticsfederation.repository.RankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RankService {
    private final RankRepository repository;

    public List<Rank> all(){
        return repository.findAll();
    }

    public Rank findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Разряд", id);
        });
    }
}
