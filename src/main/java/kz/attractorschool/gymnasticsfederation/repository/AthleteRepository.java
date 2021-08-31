package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
}
