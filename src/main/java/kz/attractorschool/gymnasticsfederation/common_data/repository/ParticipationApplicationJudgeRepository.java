package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationCoach;
import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationJudge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipationApplicationJudgeRepository extends JpaRepository<ParticipationApplicationJudge, Integer> {
    boolean existsByApplicationIdAndJudgeId(int applicationId, int judgeId);
    Optional<ParticipationApplicationJudge> findByApplicationIdAndJudgeId(int applicationId, int judgeId);
    Optional<ParticipationApplicationJudge> findByIdAndApplicationId(int id, int applicationId);
    List<ParticipationApplicationJudge> findAllByApplicationId(Integer id);
    void deleteAllByApplicationId(int applicationId);
}
