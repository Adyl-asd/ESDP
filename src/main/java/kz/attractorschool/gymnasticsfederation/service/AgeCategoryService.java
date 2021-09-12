package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.AgeCategory;
import kz.attractorschool.gymnasticsfederation.repository.AgeCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgeCategoryService {

    private final AgeCategoryRepository ageCategoryRepository;

    public List<AgeCategory> all() {
        return ageCategoryRepository.findAll();
    }

    public AgeCategory findOne(Integer id) {
        return ageCategoryRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Разряд и возраст", id);
        });
    }
}
