package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.files.PersonPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonPhotoRepository extends JpaRepository<PersonPhoto, Integer> {
}
