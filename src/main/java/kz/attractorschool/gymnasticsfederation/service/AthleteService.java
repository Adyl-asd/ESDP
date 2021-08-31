package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.AthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RankFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AthleteService {
    private final AthleteRepository repository;
    private final SchoolService schoolService;
    private final RankService rankService;
    private final DisciplineService disciplineService;
    private final PersonService personService;
    private final DopingFileRepository dopingFileRepository;
    private final RankFileRepository rankFileRepository;
    private final MedicalFileRepository medicalFileRepository;
    private final RegistryFileRepository registryFileRepository;

    public Athlete findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Спортсмен", id);
        });
    }

    public AthleteDTO getOne(Integer id){
        return AthleteDTO.from(repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Спортсмен", id);
        }));
    }


    public AthleteDTO add(AthleteAddDTO athleteDTO, RegistryFile registryFile,
                          MedicalFile medicalFile, RankFile rankFile,
                          DopingFile dopingFile){
        RegistryFile registry = registryFileRepository.save(registryFile);
        MedicalFile medical = medicalFileRepository.save(medicalFile);
        RankFile rankFile2 = rankFileRepository.save(rankFile);
        DopingFile doping = dopingFileRepository.save(dopingFile);
        School school = schoolService.findOne(athleteDTO.getSchoolId());
        Rank rank = rankService.findOne(athleteDTO.getRankId());
        Discipline discipline = disciplineService.findOne(athleteDTO.getDisciplineId());
        Person person = personService.findOne(athleteDTO.getPersonId());
        Athlete athlete = repository.save(Athlete.builder()
                .person(person)
                .school(school)
                .registryNumber("001")
                .registryFile(registry)
                .medicalFile(medical)
                .dopingFile(doping)
                .registryDate(athleteDTO.getRegistryDate())
                .discipline(discipline)
                .rank(rank)
                .rankFile(rankFile2)
                .build());
        return AthleteDTO.from(athlete);
    }
}
