package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.DisciplineTypeDTO;
import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import kz.attractorschool.gymnasticsfederation.common_data.repository.DisciplineTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DisciplineTypeService {

    DisciplineTypeRepository disciplineTypeRepository;

    public List<DisciplineType> all(){
        return disciplineTypeRepository.findAll();
    }

    public DisciplineType findOne(int id){
        return disciplineTypeRepository.findById(id).orElseThrow();
    }

    public DisciplineTypeDTO getOne(int id){
        var disciplineType = disciplineTypeRepository.findById(id).orElseThrow();
        return DisciplineTypeDTO.from(disciplineType);
    }

    public List<DisciplineType> getAllByDisciplineId(int id) {
        return disciplineTypeRepository.findAllByDisciplineId(id);
    }

    public List<DisciplineTypeDTO> getDisciplineTypesByDisciplineId(int id){
        return disciplineTypeRepository.findAllByDisciplineId(id).stream().map(DisciplineTypeDTO::from).collect(Collectors.toList());
    }

}
