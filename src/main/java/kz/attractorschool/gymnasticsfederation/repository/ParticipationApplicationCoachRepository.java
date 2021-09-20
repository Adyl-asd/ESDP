package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.ParticipationApplicationCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipationApplicationCoachRepository extends JpaRepository<ParticipationApplicationCoach, Integer> {
}
