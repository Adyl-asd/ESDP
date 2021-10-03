package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.AgeCategoryAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.AgeCategoryDTO;
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
    private final RankService rankService;

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

    public AgeCategory add(AgeCategoryAddDTO dto){
        AgeCategory ageCategory = ageCategoryRepository.save(AgeCategory.builder()
                        .discipline(disciplineTypeService.findOne(dto.getDisciplineId()))
                        .build());
        return checkData(ageCategory, dto);
    }

    public void delete(int id){
        AgeCategory ageCategory = findOne(id);
        ageCategory.setDel(true);
        ageCategoryRepository.save(ageCategory);
    }

    public AgeCategory update(int id, AgeCategoryAddDTO dto){
        AgeCategory ageCategory = findOne(id);
        ageCategory.setDiscipline(disciplineTypeService.findOne(dto.getDisciplineId()));
        return checkData(ageCategory, dto);
    }

    private AgeCategory checkData(AgeCategory ageCategory, AgeCategoryAddDTO dto){
        if (dto.getMaxYear() != null){
            ageCategory.setMaxYear(dto.getMaxYear());
        }
        else if(dto.getMinYear() != null){
            ageCategory.setMinYear(dto.getMinYear());
        }
        else if(dto.getRankId() > 0){
            ageCategory.setRank(rankService.findOne(dto.getRankId()));
        }
        return ageCategoryRepository.save(ageCategory);
    }
}
