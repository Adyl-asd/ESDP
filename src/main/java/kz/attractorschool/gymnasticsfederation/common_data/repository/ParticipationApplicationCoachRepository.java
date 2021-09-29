package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplicationCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipationApplicationCoachRepository extends JpaRepository<ParticipationApplicationCoach, Integer> {
    boolean existsByApplicationIdAndCoachId(int applicationId, int coachId);
    Optional<ParticipationApplicationCoach> findByApplicationIdAndCoachId(int applicationId, int coachId);
    Optional<ParticipationApplicationCoach> findByIdAndApplicationId(int id, int applicationId);
    List<ParticipationApplicationCoach> findAllByApplicationId(Integer id);
    void deleteAllByApplicationId(int applicationId);
}
