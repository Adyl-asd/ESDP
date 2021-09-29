package kz.attractorschool.gymnasticsfederation.common_data.specification;

import kz.attractorschool.gymnasticsfederation.dto.PersonFilter;
import kz.attractorschool.gymnasticsfederation.common_data.entity.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class RersonSpecification implements ModelSpecification<Person, PersonFilter>{


    @Override
    public Specification<Person> createSpecification(PersonFilter filter, SortingModel sortingModel) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filter != null) {
                if (!isEmpty(filter.getName())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
                }
                if (!isEmpty(filter.getSurname())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("surname")), "%" + filter.getSurname().toLowerCase() + "%"));
                }
                if (!isEmpty(filter.getCity())) {
                    predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("city")), "%" + filter.getCity().toLowerCase() + "%"));
                }
                if (!isEmpty(filter.getIin())) {
                    predicates.add(criteriaBuilder.like(root.get("iin"), "%" + filter.getIin() + "%"));
                }
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
