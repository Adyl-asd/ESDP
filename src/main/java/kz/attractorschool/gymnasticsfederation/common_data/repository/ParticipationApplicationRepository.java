package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.ParticipationApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipationApplicationRepository extends JpaRepository<ParticipationApplication, Integer> {
    Optional<ParticipationApplication> findBySchoolIdAndCompetitionId(int schoolId, int competitionId);
    boolean existsBySchoolIdAndCompetitionId(int schoolId, int competitionId);
    List<ParticipationApplication> findAllByCompetitionId(Integer id);
}
