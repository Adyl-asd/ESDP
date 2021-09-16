package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplineAgesRepository extends JpaRepository<CompetitionDisciplineAges, Integer> {
    List<CompetitionDisciplineAges> findAllByCompetitionId(Integer id);
}
