package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.SchoolDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Federation;
import kz.attractorschool.gymnasticsfederation.common_data.entity.School;
import kz.attractorschool.gymnasticsfederation.common_data.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final FederationService federationService;

    public School findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Школа", id);
        });
    }

    public SchoolDTO getOne(Integer id){
        return SchoolDTO.from(repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Школа", id);
        }));
    }

    public SchoolDTO add(SchoolDTO schoolDTO){
        Federation federation = federationService.findOne(schoolDTO.getFederationId());
        School school = repository.save(School.builder()
                .name(schoolDTO.getName())
                .address(schoolDTO.getAddress())
                .director(schoolDTO.getDirector())
                .email(schoolDTO.getEmail())
                .password(schoolDTO.getPassword())
                .phone(schoolDTO.getPhone())
                .federation(federation)
                .build());
        return SchoolDTO.from(school);
    }

    public String delete(Integer id){
        School school = findOne(id);
        school.setDel(true);
        repository.save(school);
        return "ok";
    }

    public SchoolDTO update(SchoolDTO schoolDTO, Integer id){
        School school = findOne(id);
        school.setName(schoolDTO.getName());
        school.setAddress(schoolDTO.getAddress());
        school.setDirector(schoolDTO.getDirector());
        school.setPhone(schoolDTO.getPhone());
        repository.save(school);
        return SchoolDTO.from(school);
    }

    public List<School> all(){
        return repository.findAll();
    }
}
