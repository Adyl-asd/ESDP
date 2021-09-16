package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.AgeCategory;
import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import kz.attractorschool.gymnasticsfederation.repository.AgeCategoryRepository;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgeCategoryService {
    private final DisciplineTypeService disciplineTypeService;
    private final AgeCategoryRepository ageCategoryRepository;

    public List<AgeCategory> all() {
        return ageCategoryRepository.findAll();
    }

    public AgeCategory findOne(Integer id) {
        return ageCategoryRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Разряд и возраст", id);
        });
    }

    public List<AgeCategory> allByDisciplineType(Integer id){
        DisciplineType discipline = disciplineTypeService.findOne(id);
        return discipline.getAgeCategories();
    }
}
