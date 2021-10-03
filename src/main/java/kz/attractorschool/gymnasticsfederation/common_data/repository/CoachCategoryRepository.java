package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.CoachCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachCategoryRepository extends JpaRepository<CoachCategory, Integer> {
}
