package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JudgeRepository extends JpaRepository<Judge, Integer> {
    List<Judge> findAllBySchoolId(Integer schoolId);
    List<Judge> findAllBySchoolIdAndDisciplineId(Integer schoolId, Integer disciplineId);
}
