package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.CompetitionProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionProgramRepository extends JpaRepository<CompetitionProgram, Integer> {
}
