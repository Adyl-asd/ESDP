package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.AthletesCoaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AthletesCoachesRepository extends JpaRepository<AthletesCoaches, Integer> {
    List<AthletesCoaches> findAllByAthleteIdAndSchoolId(Integer athleteId, Integer schoolId);
    Optional<AthletesCoaches> findByAthleteIdAndCoachIdAndSchoolId(Integer athleteId, Integer coachId, Integer schoolId);
}
