package kz.attractorschool.gymnasticsfederation.service;


import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.repository.DisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisciplineService {
    private final DisciplineRepository repository;

    public List<Discipline> all(){
        return repository.findAll();
    }

    public Discipline findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Дисциплина", id);
        });
    }
}
