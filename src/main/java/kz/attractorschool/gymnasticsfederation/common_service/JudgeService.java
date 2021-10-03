package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.common_data.entity.*;
import kz.attractorschool.gymnasticsfederation.common_data.repository.DopingFileRepository;
import kz.attractorschool.gymnasticsfederation.common_data.repository.JudgeCategoryFileRepository;
import kz.attractorschool.gymnasticsfederation.common_data.repository.JudgeRepository;
import kz.attractorschool.gymnasticsfederation.dto.*;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.files.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
@AllArgsConstructor
public class JudgeService {
    private final JudgeRepository repository;
    private final SchoolService schoolService;
    private final JudgeCategoryService categoryService;
    private final DisciplineService disciplineService;
    private final PersonService personService;
    private final DopingFileRepository dopingFileRepository;
    private final JudgeCategoryFileRepository categoryFileRepository;

    public List<Judge> all(){
        return repository.findAll();
    }

    public Judge findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Судья", id);
        });
    }

    public List<Judge> allBySchoolId(Integer id) {
        return repository.findAllBySchoolId(id);
    }

    public List<Judge> allBySchoolAndDisciplineId(Integer schoolId, Integer disciplineId) {
        return repository.findAllBySchoolIdAndDisciplineId(schoolId, disciplineId);
    }

    public JudgeDTO getOne(Integer id){
        return JudgeDTO.from(repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Судья", id);
        }));
    }

    public JudgeDTO add(JudgeAddDTO judgeAddDTO, JudgeCategoryFile judgeCategoryFile,
                          DopingFile dopingFile){
        Person person = personService.findOne(judgeAddDTO.getPersonId());
        School school = schoolService.findOne(judgeAddDTO.getSchoolId());
        DopingFile doping = dopingFileRepository.save(dopingFile);
        Discipline discipline = disciplineService.findOne(judgeAddDTO.getDisciplineId());
        JudgeCategory category = categoryService.findOne(judgeAddDTO.getCategoryId());
        JudgeCategoryFile categoryFile = categoryFileRepository.save(judgeCategoryFile);
        Judge judge = repository.save(Judge.builder()
                .person(person)
                .school(school)
                .registryNumber("021")
                .dopingFile(doping)
                .discipline(discipline)
                .category(category)
                .categoryFile(categoryFile)
                .build());
        return JudgeDTO.from(judge);
    }

    public String delete(Integer id){
        Judge judge = findOne(id);
        judge.setDel(true);
        repository.save(judge);
        return "ok";
    }

    public JudgeDTO update(Integer id, JudgeUpdateDTO judgeUpdateDTO){
        Judge judge = findOne(id);
        School school = schoolService.findOne(judgeUpdateDTO.getSchoolId());
        Discipline discipline = disciplineService.findOne(judgeUpdateDTO.getDisciplineId());
        JudgeCategory category = categoryService.findOne(judgeUpdateDTO.getCategoryId());
        judge.setSchool(school);
        judge.setDiscipline(discipline);
        judge.setCategory(category);
        repository.save(judge);
        return JudgeDTO.from(judge);
    }

    public Judge updateFile(Integer id, JudgeCategoryFile categoryFile){
        Judge judge = findOne(id);
        judge.setCategoryFile(categoryFileRepository.save(categoryFile));
        return judge;
    }

    public Judge updateFile(Integer id, DopingFile dopingFile){
        Judge judge = findOne(id);
        judge.setDopingFile(dopingFileRepository.save(dopingFile));
        return judge;
    }

    public boolean isPdf(MultipartFile multipartFile){
        String name = multipartFile.getOriginalFilename();
        String [] words = name.split("\\.");
        String format = words[words.length - 1];
        return format.equals("pdf");
    }

    public List<Judge> allBySchoolIdAndDisciplineId(int schoolId, int disciplineId){
        return repository.findAllBySchoolIdAndDisciplineId(schoolId, disciplineId);
    }
}
