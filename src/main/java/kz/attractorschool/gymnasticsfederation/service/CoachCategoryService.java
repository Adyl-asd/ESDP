package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.CoachCategory;
import kz.attractorschool.gymnasticsfederation.repository.CoachCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoachCategoryService {

    CoachCategoryRepository repository;

    public List<CoachCategory> all(){
        return repository.findAll();
    }

    public CoachCategory findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Категория тренера", id);
        });
    }
}
