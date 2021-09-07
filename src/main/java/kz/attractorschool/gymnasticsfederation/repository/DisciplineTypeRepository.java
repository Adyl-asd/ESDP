package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.DisciplineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineTypeRepository extends JpaRepository<DisciplineType, Integer> {
}
