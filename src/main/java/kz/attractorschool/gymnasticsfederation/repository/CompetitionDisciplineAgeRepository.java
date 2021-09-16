package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplineAgeRepository extends JpaRepository<CompetitionDisciplineAge, Integer> {
    List<CompetitionDisciplineAge> findAllByCompetitionId(Integer id);
}
