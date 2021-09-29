package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.FederationDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Federation;
import kz.attractorschool.gymnasticsfederation.common_data.repository.FederationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FederationService {
    private final FederationRepository repository;

    public Federation findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Федерация", id);
        });
    }

    public FederationDTO getOne(Integer id){
        return FederationDTO.from(repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Федерация", id);
        }));
    }

    public FederationDTO add(FederationDTO federationDTO){
        Federation federation = repository.save(Federation.builder()
                .name(federationDTO.getName())
                .director(federationDTO.getDirector())
                .address(federationDTO.getAddress())
                .email(federationDTO.getEmail())
                .password(federationDTO.getPassword())
                .phone(federationDTO.getPhone())
                .build());
        return FederationDTO.from(federation);
    }

    public String delete(Integer id){
        Federation federation = findOne(id);
        federation.setDel(true);
        repository.save(federation);
        return "ok";
    }

    public FederationDTO update(FederationDTO dto, Integer id){
        Federation federation = findOne(id);
        federation.setName(dto.getName());
        federation.setDirector(dto.getDirector());
        federation.setAddress(dto.getAddress());
        federation.setPhone(dto.getPhone());
        repository.save(federation);
        return FederationDTO.from(federation);
    }

    public List<Federation> all(){
        return repository.findAll();
    }
}
