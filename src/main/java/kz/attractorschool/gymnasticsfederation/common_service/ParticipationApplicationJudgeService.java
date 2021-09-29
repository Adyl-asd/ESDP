package kz.attractorschool.gymnasticsfederation.common_service;

import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationJudgeAddDTO;
import kz.attractorschool.gymnasticsfederation.dto.ParticipationApplicationJudgeDTO;
import kz.attractorschool.gymnasticsfederation.exception.ResourceNotFoundException;
import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplication;
import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationJudge;
import kz.attractorschool.gymnasticsfederation.common_data.repository.ParticipationApplicationJudgeRepository;
import kz.attractorschool.gymnasticsfederation.common_data.repository.ParticipationApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ParticipationApplicationJudgeService {
    private final ParticipationApplicationJudgeRepository repository;
    private final ParticipationApplicationRepository applicationRepository;
    private final JudgeService judgeService;

    public List<ParticipationApplicationJudge> all(){
        return repository.findAll();
    }

    public ParticipationApplicationJudge findOne(Integer id){
        return repository.findById(id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
    }

    public ParticipationApplicationJudgeDTO getOne(Integer id){
        return ParticipationApplicationJudgeDTO.from(findOne(id));
    }

    public ParticipationApplicationJudgeDTO add(ParticipationApplicationJudgeAddDTO dto){
        ParticipationApplication application = applicationRepository.findById(dto.getApplicationId()).orElseThrow(() ->{
            return new ResourceNotFoundException("Заявка", 0);
        });
//        if (repository.existsByApplicationIdAndJudgeId(dto.getApplicationId(), dto.getJudgeId())){
//            return ParticipationApplicationJudgeDTO.from(repository.findByApplicationIdAndJudgeId(dto.getApplicationId(), dto.getJudgeId()).orElseThrow(() -> {
//                return new ResourceNotFoundException("Заявка", 0);
//            }));
//        }
        ParticipationApplicationJudge applicationJudge = repository.save(
                ParticipationApplicationJudge.builder()
                        .application(application)
                        .judge(judgeService.findOne(dto.getJudgeId()))
                        .build());
        return ParticipationApplicationJudgeDTO.from(applicationJudge);
    }

    public void delete(int applicationId, int id){
        ParticipationApplicationJudge applicationJudge = repository.findByIdAndApplicationId(applicationId, id).orElseThrow(() -> {
            return new ResourceNotFoundException("Заявка", id);
        });
        repository.delete(applicationJudge);
    }

    public void delete(List<ParticipationApplicationJudge> applicationJudges){
        repository.deleteAll(applicationJudges);
    }
}
