package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplineAges;
import kz.attractorschool.gymnasticsfederation.model.CompetitionDisciplinePrograms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplineProgramsRepository extends JpaRepository<CompetitionDisciplinePrograms, Integer> {
    List<CompetitionDisciplinePrograms> findAllByCompetitionId(Integer id);

}
