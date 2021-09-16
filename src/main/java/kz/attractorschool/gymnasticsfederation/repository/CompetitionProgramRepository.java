package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.CompetitionProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionProgramRepository extends JpaRepository<CompetitionProgram, Integer> {
    List<CompetitionProgram> findAllByDisciplineId(Integer id);
}
