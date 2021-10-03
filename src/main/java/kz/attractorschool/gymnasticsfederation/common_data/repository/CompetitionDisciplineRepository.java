package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CompetitionDiscipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDisciplineRepository extends JpaRepository<CompetitionDiscipline, Integer> {
    List<CompetitionDiscipline> findAllByCompetitionId(Integer id);
}
