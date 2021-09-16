package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineTypeRepository extends JpaRepository<DisciplineType, Integer> {
    List<DisciplineType> findAllByDisciplineId(int disciplineId);
}
