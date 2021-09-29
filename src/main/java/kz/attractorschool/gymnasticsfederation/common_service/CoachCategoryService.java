package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.CoachCategoryDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.CoachCategory;
import kz.attractorschool.gymnasticsfederation.common_data.repository.CoachCategoryRepository;
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

    public CoachCategoryDTO getOne(Integer id){
        return CoachCategoryDTO.from(findOne(id));
    }

    public CoachCategoryDTO add(CoachCategoryDTO coachCategoryDTO){
        CoachCategory coachCategory = repository.save(CoachCategory.builder()
                .name(coachCategoryDTO.getName())
                .build());
        return CoachCategoryDTO.from(coachCategory);
    }

    public String delete(Integer id){
        CoachCategory coachCategory = findOne(id);
        coachCategory.setDel(true);
        repository.save(coachCategory);
        return "ok";
    }

    public CoachCategoryDTO update(CoachCategoryDTO coachCategoryDTO, Integer id){
        CoachCategory coachCategory = findOne(id);
        coachCategory.setName(coachCategoryDTO.getName());
        repository.save(coachCategory);
        return CoachCategoryDTO.from(coachCategory);
    }
}
