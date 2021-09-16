package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.files.CompetitionPositionFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionFileRepository extends JpaRepository<CompetitionPositionFile, Integer> {
}
