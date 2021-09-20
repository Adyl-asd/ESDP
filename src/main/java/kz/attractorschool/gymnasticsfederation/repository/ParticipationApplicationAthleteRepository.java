package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationAthlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationApplicationAthleteRepository extends JpaRepository<ParticipationApplicationAthlete, Integer> {
}
