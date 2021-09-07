package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import kz.attractorschool.gymnasticsfederation.repository.DisciplineTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DisciplineTypeService {

    DisciplineTypeRepository disciplineTypeRepository;

    public List<DisciplineType> all(){
        return disciplineTypeRepository.findAll();
    }

}
