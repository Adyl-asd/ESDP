package kz.attractorschool.gymnasticsfederation.service;


import kz.attractorschool.gymnasticsfederation.dto.DisciplineDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.Discipline;
import kz.attractorschool.gymnasticsfederation.repository.DisciplineRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DisciplineService {
    private final DisciplineRepository repository;

    public List<Discipline> all(){
        return repository.findAll();
    }

    public Discipline findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Дисциплина", id);
        });
    }

    public DisciplineDTO getOne(Integer id){
        return DisciplineDTO.from(findOne(id));
    }

    public DisciplineDTO add(DisciplineDTO disciplineDTO){
        Discipline discipline = repository.save(Discipline.builder()
                .name(disciplineDTO.getName())
                .build());
        return DisciplineDTO.from(discipline);
    }

    public String delete(Integer id){
        Discipline discipline = findOne(id);
        discipline.setDel(true);
        repository.save(discipline);
        return "ok";
    }

    public DisciplineDTO update(DisciplineDTO disciplineDTO, Integer id){
        Discipline discipline = findOne(id);
        discipline.setName(disciplineDTO.getName());
        repository.save(discipline);
        return DisciplineDTO.from(discipline);
    }

    public List<DisciplineDTO> getAll(){
        return repository.findAll().stream().map(DisciplineDTO::from).collect(Collectors.toList());
    }
}
