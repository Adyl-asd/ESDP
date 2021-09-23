package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipationApplicationAthleteRepository extends JpaRepository<ParticipationApplicationAthlete, Integer> {
    boolean existsByApplicationIdAndAthleteIdAndDisciplineAgeId(int applicationId, int athleteId, int ageId);
    Optional<ParticipationApplicationAthlete> findByApplicationIdAndAthleteIdAndDisciplineAgeId(int applicationId, int athleteId, int ageId);
}
