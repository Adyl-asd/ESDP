package kz.attractorschool.gymnasticsfederation.repository;

import jdk.dynalink.linker.LinkerServices;
import kz.attractorschool.gymnasticsfederation.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {
    List<Coach> findAllBySchoolIdAndDisciplineId(Integer schoolId, Integer disciplineId);
    List<Coach> findAllBySchoolId(Integer id);
}
