package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.AgeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgeCategoryRepository extends JpaRepository<AgeCategory, Integer> {
    List<AgeCategory> findAllByDisciplineId(Integer id);
}
