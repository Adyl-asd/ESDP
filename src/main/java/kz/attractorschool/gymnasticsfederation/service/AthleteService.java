package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.AthleteAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteDTO;
import kz.attractorschool.gymnasticsfederation.dto.AthleteRegisterDTO;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private final CoachService coachService;
    private final AthletesCoachesRepository athletesCoachesRepository;

    public List<Athlete> all(){
        List<Athlete> athletes = repository.findAll();
        return checkStatus(athletes);
    }

    public List<Athlete> findAllBySchoolId(Integer id) {
        List<Athlete> athletes = repository.findAllBySchoolId(id);
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
                .isCityTeam(isTeam(athleteDTO.getIsCityTeam()))
                .isNationalTeam(isTeam(athleteDTO.getIsNationalTeam()))
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
        athlete.setNationalTeam(isTeam(athleteDTO.getIsNationalTeam()));
        athlete.setCityTeam(isTeam(athleteDTO.getIsCityTeam()));
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
        String [] words = name.split("\\.");
        String format = words[words.length - 1];
        return format.equals("pdf");
    }

    public AthleteDTO confirm(Integer id){
        Athlete athlete = findOne(id);
        athlete.setStatus(Status.АКТИВНЫЙ.toString());
        repository.save(athlete);
        return AthleteDTO.from(athlete);
    }

    public List<Athlete> checkStatus (List<Athlete> athletes){
        for (int i = 0; i < athletes.size(); i++) {
            if (athletes.get(i).getRegistryDate().plusYears(1).isBefore(LocalDate.now())){
                athletes.get(i).setStatus(Status.ИСТЕК.toString());
                repository.save(athletes.get(i));
            }
            else if (athletes.get(i).getRegistryDate().plusMonths(14).isBefore(LocalDate.now())) {
                athletes.get(i).setStatus(Status.НЕАКТИВНЫЙ.toString());
                repository.save(athletes.get(i));
            }
        }
        return athletes;
    }

    public AthleteDTO checkStatus (Athlete athlete){
        if (athlete.getRegistryDate().plusMonths(12).isBefore(LocalDate.now())) {
            athlete.setStatus(Status.ИСТЕК.toString());
            repository.save(athlete);
        }
        else if (athlete.getRegistryDate().plusMonths(14).isBefore(LocalDate.now())) {
            athlete.setStatus(Status.НЕАКТИВНЫЙ.toString());
            repository.save(athlete);
        }
        return AthleteDTO.from(athlete);
    }

    public AthleteDTO register(Integer id, AthleteRegisterDTO athleteDTO, MedicalFile medicalFile,
                               RankFile rankFile, DopingFile dopingFile){
        Athlete athlete = findOne(id);
        Rank rank = rankService.findOne(athleteDTO.getRankId());
        athlete.setRank(rank);
        School school = schoolService.findOne(athleteDTO.getSchoolId());
        athlete.setSchool(school);
        athlete.setStatus(athleteDTO.getStatus());
        athlete.setRegistryDate(athleteDTO.getRegistryDate());
        MedicalFile medical = medicalFileRepository.save(medicalFile);
        RankFile rankFile2 = rankFileRepository.save(rankFile);
        DopingFile doping = dopingFileRepository.save(dopingFile);
        athlete.setDopingFile(doping);
        athlete.setMedicalFile(medical);
        athlete.setRankFile(rankFile2);
        repository.save(athlete);
        return AthleteDTO.from(athlete);
    }

    public AthleteDTO addCoach(Integer id, Integer coachId){
        Athlete athlete = findOne(id);
        Coach coach = coachService.findOne(coachId);
        athletesCoachesRepository.save(AthletesCoaches.builder()
                        .athlete(athlete)
                        .coach(coach)
                        .school(athlete.getSchool())
                .build());
        return AthleteDTO.from(athlete);
    }

    public List<Coach> coaches(Integer id){
        Athlete athlete = findOne(id);
        List<AthletesCoaches> coachesAthletes = athletesCoachesRepository.findAllByAthleteIdAndSchoolId(id, athlete.getSchool().getId());
        List<Coach> coaches = new ArrayList<>();
        for (int i = 0; i < coachesAthletes.size(); i++) {
            if (coachesAthletes.get(i).getFinishDate() == null){
                coaches.add(coachesAthletes.get(i).getCoach());
            }
        }
        return coaches;
    }

    public List<AthletesCoaches> coachesHistory(Integer id){
        Athlete athlete = findOne(id);
        List<AthletesCoaches> coaches = new ArrayList<>();
        List<Coach> all = coaches(id);
        for (int i = 0; i < all.size(); i++) {
            coaches.add(athletesCoachesRepository.findByAthleteIdAndCoachIdAndSchoolId(id, all.get(i).getId(), athlete.getSchool().getId()).orElseThrow());
        }
        return coaches;
    }

    public AthleteDTO deleteCoach(Integer id, Integer coachId){
        Athlete athlete = findOne(id);
        Coach coach = coachService.findOne(coachId);
        AthletesCoaches athletesCoaches = athletesCoachesRepository.findByAthleteIdAndCoachIdAndSchoolId(id, coachId, athlete.getSchool().getId()).orElseThrow(()->{
            return new ResourceNotFoundException("Запись о тренере и спортсмене", 0);
        });
        athletesCoaches.setFinishDate(LocalDate.now());
        athletesCoachesRepository.save(athletesCoaches);
        return AthleteDTO.from(athlete);
    }

    public Set<Coach> universalCoaches(AthleteDTO athleteDTO){
        Athlete athlete = findOne(athleteDTO.getId());
        List<Coach> coaches = coachService.getByDisciplineAndSchool(athleteDTO);
        Set<Coach> universalCoaches = new HashSet<>();
        if (athlete.getCoaches().size() == 0){
            universalCoaches.addAll(coaches);
        }
        for (int i = 0; i < coaches.size(); i++) {
            for (int j = 0; j < athlete.getCoaches().size(); j++) {
                if (!athlete.getCoaches().get(j).equals(coaches.get(i))){
                    universalCoaches.add(coaches.get(i));
                }
            }
        }
        return universalCoaches;
    }

    private boolean isTeam(String result){
        return result.equals("да");
    }
}
