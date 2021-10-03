package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Discipline;
import kz.attractorschool.gymnasticsfederation.common_data.repository.GenderRepository;
import kz.attractorschool.gymnasticsfederation.dto.DisciplineTypeAddDTO;
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
    private final DisciplineService disciplineService;
    private final DisciplineTypeRepository repository;
    private final GenderRepository genderRepository;

    public List<DisciplineType> all(){
        return repository.findAll();
    }

    public DisciplineType findOne(int id){
        return repository.findById(id).orElseThrow();
    }

    public DisciplineTypeDTO getOne(int id){
        var disciplineType = repository.findById(id).orElseThrow();
        return DisciplineTypeDTO.from(disciplineType);
    }

    public List<DisciplineType> getAllByDisciplineId(int id) {
        return repository.findAllByDisciplineId(id);
    }

    public List<DisciplineTypeDTO> getDisciplineTypesByDisciplineId(int id){
        return repository.findAllByDisciplineId(id).stream().map(DisciplineTypeDTO::from).collect(Collectors.toList());
    }

    public DisciplineTypeDTO add(DisciplineTypeAddDTO dto){
        Discipline discipline = disciplineService.findOne(dto.getDisciplineId());
        DisciplineType disciplineType = repository.save(DisciplineType.builder()
                        .name(dto.getName())
                        .discipline(discipline)
                        .gender(genderRepository.findByName(dto.getGender()))
                        .build());
        if (dto.getParticipantsAmountMax() != null){
            disciplineType.setParticipantsAmountMax(dto.getParticipantsAmountMax());
        }
        else if(dto.getParticipantsAmountMin() != null){
            disciplineType.setParticipantsAmountMin(dto.getParticipantsAmountMin());
        }
        return DisciplineTypeDTO.from(disciplineType);
    }

    public DisciplineType delete(int id){
        DisciplineType disciplineType = findOne(id);
        disciplineType.setDel(true);
        repository.save(disciplineType);
        return disciplineType;
    }

    public DisciplineTypeDTO update(int id, DisciplineTypeAddDTO dto){
        DisciplineType disciplineType = findOne(id);
        disciplineType.setDiscipline(disciplineService.findOne(dto.getDisciplineId()));
        disciplineType.setGender(genderRepository.findByName(dto.getGender()));
        if(dto.getParticipantsAmountMin() != null){
            disciplineType.setParticipantsAmountMin(dto.getParticipantsAmountMin());
        }
        else if (dto.getParticipantsAmountMax() != null){
            disciplineType.setParticipantsAmountMax(dto.getParticipantsAmountMax());
        }
        repository.save(disciplineType);
        return DisciplineTypeDTO.from(disciplineType);
    }
}
