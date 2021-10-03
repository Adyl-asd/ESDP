package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.DisciplineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineTypeRepository extends JpaRepository<DisciplineType, Integer> {
    List<DisciplineType> findAllByDisciplineId(int disciplineId);
}
