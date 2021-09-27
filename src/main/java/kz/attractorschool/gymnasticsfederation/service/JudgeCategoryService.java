package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.JudgeCategoryDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.CoachCategory;
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

    public JudgeCategoryDTO getOne(Integer id){
        return JudgeCategoryDTO.from(findOne(id));
    }

    public JudgeCategoryDTO add(JudgeCategoryDTO judgeCategoryDTO){
        JudgeCategory judgeCategory = repository.save(JudgeCategory.builder()
                .name(judgeCategoryDTO.getName())
                .build());
        return JudgeCategoryDTO.from(judgeCategory);
    }

    public String delete(Integer id){
        JudgeCategory judgeCategory = findOne(id);
        judgeCategory.setDel(true);
        repository.save(judgeCategory);
        return "ok";
    }

    public JudgeCategoryDTO update(JudgeCategoryDTO judgeCategoryDTO, Integer id){
        JudgeCategory judgeCategory = findOne(id);
        judgeCategory.setName(judgeCategoryDTO.getName());
        repository.save(judgeCategory);
        return JudgeCategoryDTO.from(judgeCategory);
    }
}
