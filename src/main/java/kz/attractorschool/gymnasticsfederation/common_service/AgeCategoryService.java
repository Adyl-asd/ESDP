package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.AgeCategory;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.AgeCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
