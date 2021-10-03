package kz.attractorschool.gymnasticsfederation.common_data.repository;

import kz.attractorschool.gymnasticsfederation.common_data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

public interface PersonRepository extends JpaRepository <Person, Integer>, QuerydslPredicateExecutor<Person>, JpaSpecificationExecutor<Person> {
    boolean existsByIin(String iin);
}
