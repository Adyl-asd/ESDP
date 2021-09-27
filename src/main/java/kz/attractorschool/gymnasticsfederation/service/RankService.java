package kz.attractorschool.gymnasticsfederation.service;

import kz.attractorschool.gymnasticsfederation.dto.RankDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.model.Rank;
import kz.attractorschool.gymnasticsfederation.repository.RankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RankService {
    private final RankRepository repository;

    public List<Rank> all(){
        return repository.findAll();
    }

    public Rank findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Разряд", id);
        });
    }

    public RankDTO getOne(Integer id){
        return RankDTO.from(findOne(id));
    }

    public RankDTO add(RankDTO rankDTO){
        Rank rank = repository.save(Rank.builder()
                .name(rankDTO.getName())
                .build());
        return RankDTO.from(rank);
    }

    public String delete(Integer id){
        Rank rank = findOne(id);
        rank.setDel(true);
        repository.save(rank);
        return "ok";
    }

    public RankDTO update(RankDTO rankDTO, Integer id){
        Rank rank = findOne(id);
        rank.setName(rankDTO.getName());
        repository.save(rank);
        return RankDTO.from(rank);
    }
}
