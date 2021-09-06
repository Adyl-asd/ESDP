package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.AthleteDTO;
import kz.attractorschool.gymnasticsfederation.dto.CoachAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CoachDTO;
import kz.attractorschool.gymnasticsfederation.dto.CoachUpdateDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.files.CoachCategoryFile;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.CoachCategoryFileRepository;
import kz.attractorschool.gymnasticsfederation.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;
    private final PersonService personService;
    private final SchoolService schoolService;
    private final DisciplineService disciplineService;
    private final CoachCategoryService coachCategoryService;
    private final CoachCategoryFileRepository coachCategoryFileRepository;

    public List<Coach> all() {
        return coachRepository.findAll();
    }

    public Coach findOne(Integer id) {
        return coachRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Тренер", id);
        });
    }

    public CoachDTO getOne(Integer id) {
        return CoachDTO.from(coachRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Тренер", id);
        }));
    }

    public CoachDTO add(CoachAddDTO coachDTO, CoachCategoryFile coachCategoryFile) {
        CoachCategoryFile categoryFile = coachCategoryFileRepository.save(coachCategoryFile);
        CoachCategory category = coachCategoryService.findOne(coachDTO.getCategoryId());
        School school = schoolService.findOne(coachDTO.getSchoolId());
        Discipline discipline = disciplineService.findOne(coachDTO.getDisciplineId());
        Person person = personService.findOne(coachDTO.getPersonId());
        Coach coach = coachRepository.save(Coach.builder()
                .person(person)
                .school(school)
                .registryNumber("011")
                .category(category)
                .categoryFile(categoryFile)
                .discipline(discipline)
                .build());
        return CoachDTO.from(coach);
    }

    public String delete(Integer id) {
        Coach coach = findOne(id);
        coach.setDel(true);
        coachRepository.save(coach);
        return "ok";
    }

    public CoachDTO update(Integer id, CoachUpdateDTO coachUpdateDTO) {
        Coach coach = findOne(id);
        if (coachUpdateDTO.getSchoolId() != null) {
            School school = schoolService.findOne(coachUpdateDTO.getSchoolId());
            coach.setSchool(school);
        }
        if (coachUpdateDTO.getCategoryId() != null) {
            CoachCategory category = coachCategoryService.findOne(coachUpdateDTO.getCategoryId());
            coach.setCategory(category);
        }
        if (coachUpdateDTO.getDisciplineId() != null) {
            Discipline discipline = disciplineService.findOne(coachUpdateDTO.getDisciplineId());
            coach.setDiscipline(discipline);
        }

        coachRepository.save(coach);
        return CoachDTO.from(coach);
    }

    public Coach updateFile(Integer id, CoachCategoryFile categoryFile){
        Coach coach = findOne(id);
        CoachCategoryFile coachCategoryFile = coachCategoryFileRepository.save(categoryFile);
        coach.setCategoryFile(coachCategoryFile);
        return coach;
    }

    public boolean isPdf(MultipartFile multipartFile) {
        String name = multipartFile.getOriginalFilename();
        String format = name.split("\\.")[2];
        return format.equals("pdf");
    }

    public List<Coach> getByDisciplineAndSchool(AthleteDTO athleteDTO){
        return coachRepository.findAllBySchoolIdAndDisciplineId(athleteDTO.getSchool().getId(),
                athleteDTO.getDiscipline().getId());
    }
}
