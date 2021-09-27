package kz.attractorschool.gymnasticsfederation.service;


import kz.attractorschool.gymnasticsfederation.dto.CompetitionAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionDTO;
import kz.attractorschool.gymnasticsfederation.dto.CompetitionUpdateDTO;
import kz.attractorschool.gymnasticsfederation.enumm.CompetitionLevel;
import kz.attractorschool.gymnasticsfederation.enumm.CompetitionStatus;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.model.School;
import kz.attractorschool.gymnasticsfederation.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final DisciplineService disciplineService;
    private final SchoolService schoolService;
    private final CompetitionFileRepository competitionFileRepository;

    public Competition findOne(int id) {
        return competitionRepository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Соревнование", id);
        });
    }

    public CompetitionDTO getOne(int id){
        return CompetitionDTO.from(findOne(id));
    }

    public List<Competition> all() {
        return competitionRepository.findAll();
    }

    public CompetitionDTO add(CompetitionAddDTO competitionAddDTO, CompetitionPositionFile positionFile) {
        Discipline discipline = disciplineService.findOne(competitionAddDTO.getDisciplineId());
        School school = schoolService.findOne(competitionAddDTO.getSchoolId());
        CompetitionPositionFile competitionPositionFile = competitionFileRepository.save(positionFile);
        Competition competition = competitionRepository.save(Competition.builder()
                .name(competitionAddDTO.getName())
                .startDate(competitionAddDTO.getStartDate())
                .finishDate(competitionAddDTO.getFinishDate())
                .participationDate(competitionAddDTO.getParticipationDate())
                .country(competitionAddDTO.getCountry())
                .city(competitionAddDTO.getCity())
                .address(competitionAddDTO.getAddress())
                .areaName(competitionAddDTO.getAreaName())
                .level(competitionAddDTO.getLevel())
                .contact(competitionAddDTO.getContactName())
                .phone(competitionAddDTO.getContactPhone())
                .discipline(discipline)
                .competitionPositionFile(competitionPositionFile)
                .school(school)
                .build());
        return CompetitionDTO.from(competition);
    }

    public CompetitionDTO update(Integer id, CompetitionUpdateDTO competitionUpdateDTO, CompetitionPositionFile positionFile) {
        Discipline discipline = disciplineService.findOne(competitionUpdateDTO.getDisciplineId());
        School school = schoolService.findOne(competitionUpdateDTO.getSchoolId());
        CompetitionPositionFile competitionPositionFile = competitionFileRepository.save(positionFile);
        Competition competition = findOne(id);
        competition.setName(competitionUpdateDTO.getName());
        competition.setStartDate(competitionUpdateDTO.getStartDate());
        competition.setFinishDate(competitionUpdateDTO.getFinishDate());
        competition.setParticipationDate(competitionUpdateDTO.getParticipationDate());
        competition.setLevel(competitionUpdateDTO.getLevel());
        competition.setCountry(competitionUpdateDTO.getCountry());
        competition.setCity(competitionUpdateDTO.getCity());
        competition.setAddress(competitionUpdateDTO.getAddress());
        competition.setAreaName(competitionUpdateDTO.getAreaName());
        competition.setContact(competitionUpdateDTO.getContactName());
        competition.setPhone(competitionUpdateDTO.getContactPhone());
        competition.setDiscipline(discipline);
        competition.setCompetitionPositionFile(competitionPositionFile);
        competition.setSchool(school);
        competitionRepository.save(competition);
        return CompetitionDTO.from(competition);
    }

    public String delete(Integer id){
        Competition competition = findOne(id);
        competition.setDel(true);
        competitionRepository.save(competition);
        return "ok";
    }

    public List<String> getLevels() {
        CompetitionLevel[] arr = CompetitionLevel.values();
        List<String> levels = new ArrayList<>();
        for (CompetitionLevel competitionLevel : arr) {
            levels.add(competitionLevel.getName());
        }
        return levels;
    }

    public boolean isPdf(MultipartFile multipartFile) {
        String name = multipartFile.getOriginalFilename();
        String[] words = name.split("\\.");
        String format = words[words.length - 1];
        return format.equals("pdf");
    }

    public CompetitionDTO confirm(int id){
        Competition competition = findOne(id);
        competition.setStatus(CompetitionStatus.CONFIRMED.getName());
        competitionRepository.save(competition);
        return CompetitionDTO.from(competition);
    }
}
