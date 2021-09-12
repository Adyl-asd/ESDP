package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplinesRepository extends JpaRepository<CompetitionDisciplines, Integer> {
    List<CompetitionDisciplines> findAllByCompetitionId(Integer id);
}
