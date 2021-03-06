package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDisciplineProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplineProgramRepository extends JpaRepository<CompetitionDisciplineProgram, Integer> {
    List<CompetitionDisciplineProgram> findAllByCompetitionId(Integer id);

}
