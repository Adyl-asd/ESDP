package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Integer> {
    List<Athlete> findAllBySchoolId(Integer id);
    List<Athlete> findAllBySchoolIdAndDisciplineId(Integer schoolId, Integer disciplineId);
}
