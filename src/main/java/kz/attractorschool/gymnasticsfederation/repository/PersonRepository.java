package kz.attractorschool.gymnasticsfederation.repository;

import kz.attractorschool.gymnasticsfederation.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface PersonRepository extends JpaRepository <Person, Integer>, QuerydslPredicateExecutor<Person> {
    boolean existsByIin(String iin);
}
