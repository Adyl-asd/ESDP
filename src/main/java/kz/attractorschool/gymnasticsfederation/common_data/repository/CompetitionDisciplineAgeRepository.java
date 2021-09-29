package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDisciplineAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplineAgeRepository extends JpaRepository<CompetitionDisciplineAge, Integer> {
    List<CompetitionDisciplineAge> findAllByCompetitionId(Integer id);
}
