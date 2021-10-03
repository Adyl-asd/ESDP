package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.files.MedicalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalFileRepository extends JpaRepository<MedicalFile, Integer> {
}
