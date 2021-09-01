package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.JudgeCategory;
import kz.attractorschool.gymnasticsfederation.repository.JudgeCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JudgeCategoryService {

    JudgeCategoryRepository repository;

    public List<JudgeCategory> all(){
        return repository.findAll();
    }

    public JudgeCategory findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Категория судьи", id);
        });
    }
}
