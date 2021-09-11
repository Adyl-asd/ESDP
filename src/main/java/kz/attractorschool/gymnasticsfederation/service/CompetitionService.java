package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.CompetitionDTO;
import kz.attractorschool.gymnasticsfederation.dto.DisciplineTypeDTO;
import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import kz.attractorschool.gymnasticsfederation.model.Competition;
import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import kz.attractorschool.gymnasticsfederation.model.School;
import kz.attractorschool.gymnasticsfederation.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class    CompetitionService {
    private final CompetitionRepository repository;
    private final DisciplineRepository disciplineRepository;
    private final SchoolRepository schoolRepository;
    private final CompetitionFileRepository fileRepository;
    private final DisciplineTypeRepository disciplineTypeRepository;

    public CompetitionDTO getOne(int id){
        Competition competition = repository.findById(id).orElseThrow();
        return CompetitionDTO.from(competition);
    }

    public List<CompetitionDTO> getAll(){
        return repository.findAll().stream().map(CompetitionDTO::from).collect(Collectors.toList());
    }

    public Competition create(Competition competition, CompetitionPositionFile positionFile ){
        Discipline discipline = disciplineRepository.getById(competition.getDiscipline().getId());
        School school = schoolRepository.getById(competition.getSchool().getId());
        CompetitionPositionFile competitionPositionFile = fileRepository.save(positionFile);
        return repository.save(Competition.builder()
                .name(competition.getName())
                .startDate(competition.getStartDate())
                .finishDate(competition.getFinishDate())
                .country(competition.getCountry())
                .city(competition.getCity())
                .address(competition.getAddress())
                .areaName(competition.getAreaName())
                .contact(competition.getContact())
                .phone(competition.getPhone())
                .discipline(discipline)
                .competitionPositionFile(competitionPositionFile)
                .school(school)
                .build());
    }

    public boolean isPdf(MultipartFile multipartFile){
        String name = multipartFile.getOriginalFilename();
        String [] words = name.split("\\.");
        String format = words[words.length - 1];
        return format.equals("pdf");
    }


}
