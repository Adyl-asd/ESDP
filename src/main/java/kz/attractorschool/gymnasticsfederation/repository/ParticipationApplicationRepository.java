package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.ParticipationApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipationApplicationRepository extends JpaRepository<ParticipationApplication, Integer> {
    Optional<ParticipationApplication> findBySchoolIdAndCompetitionId(int schoolId, int competitionId);
}
