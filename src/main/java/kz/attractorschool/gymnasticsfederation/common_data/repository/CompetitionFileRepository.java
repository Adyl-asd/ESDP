package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.files.CompetitionPositionFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionFileRepository extends JpaRepository<CompetitionPositionFile, Integer> {
}
