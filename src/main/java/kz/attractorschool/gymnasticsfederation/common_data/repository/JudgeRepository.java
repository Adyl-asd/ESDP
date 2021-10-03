package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Judge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JudgeRepository extends JpaRepository<Judge, Integer> {
    List<Judge> findAllBySchoolId(Integer schoolId);
    List<Judge> findAllBySchoolIdAndDisciplineId(Integer schoolId, Integer disciplineId);
}
