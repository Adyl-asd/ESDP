package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.AthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteUpdateDTO;
import kz.attractorschool.gymnasticsfederation.enumm.Status;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.files.DopingFile;
import kz.attractorschool.gymnasticsfederation.files.MedicalFile;
import kz.attractorschool.gymnasticsfederation.files.RankFile;
import kz.attractorschool.gymnasticsfederation.files.RegistryFile;
import kz.attractorschool.gymnasticsfederation.model.*;
import kz.attractorschool.gymnasticsfederation.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

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

    public List<Athlete> all(){
        List<Athlete> athletes = repository.findAll();
        return checkStatus(athletes);
    }

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

    public String delete(Integer id){
        Athlete athlete = findOne(id);
        athlete.setDel(true);
        repository.save(athlete);
        return "ok";
    }

    public AthleteDTO update(Integer id, AthleteUpdateDTO athleteDTO){
        Athlete athlete = findOne(id);
        School school = schoolService.findOne(athleteDTO.getSchoolId());
        Rank rank = rankService.findOne(athleteDTO.getRankId());
        Discipline discipline = disciplineService.findOne(athleteDTO.getDisciplineId());
        athlete.setDiscipline(discipline);
        athlete.setSchool(school);
        athlete.setRank(rank);
        repository.save(athlete);
        return AthleteDTO.from(athlete);
    }

    public Athlete updateFile(Integer id, RegistryFile registryFile){
        Athlete athlete = findOne(id);
        RegistryFile registry = registryFileRepository.save(registryFile);
        athlete.setRegistryFile(registry);
        return athlete;
    }

    public Athlete updateFile(Integer id, MedicalFile medicalFile){
        Athlete athlete = findOne(id);
        MedicalFile medical = medicalFileRepository.save(medicalFile);
        athlete.setMedicalFile(medical);
        return athlete;
    }

    public Athlete updateFile(Integer id, RankFile rankFile){
        Athlete athlete = findOne(id);
        RankFile rankFile2 = rankFileRepository.save(rankFile);
        athlete.setRankFile(rankFile2);
        return athlete;
    }

    public Athlete updateFile(Integer id, DopingFile dopingFile){
        Athlete athlete = findOne(id);
        DopingFile doping = dopingFileRepository.save(dopingFile);
        athlete.setDopingFile(doping);
        return athlete;
    }

    public boolean isPdf(MultipartFile multipartFile){
        String name = multipartFile.getOriginalFilename();
        String format = name.split("\\.")[1];
        return format.equals("pdf");
    }

    public AthleteDTO confirm(Integer id){
        Athlete athlete = findOne(id);
        athlete.setStatus(Status.АКТИВНЫЙ.toString());
        repository.save(athlete);
        return AthleteDTO.from(athlete);
    }

    private List<Athlete> checkStatus (List<Athlete> athletes){
        for (int i = 0; i < athletes.size(); i++) {
            if (athletes.get(i).getRegistryDate().plusYears(1).isAfter(LocalDate.now())){
                athletes.get(i).setStatus(Status.ИСТЕК.toString());
                repository.save(athletes.get(i));
            }
            else if (athletes.get(i).getRegistryDate().plusMonths(14).isAfter(LocalDate.now())) {
                athletes.get(i).setStatus(Status.НЕАКТИВНЫЙ.toString());
                repository.save(athletes.get(i));
            }
        }
        return athletes;
    }
}
