package kz.attractorschool.gymnasticsfederation.common_data.specification;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public interface ModelSpecification<T, R extends FilterModel> {

    Specification<T> createSpecification(R filter, SortingModel sorting);

    default void sorting(Root<T> root,
                         CriteriaQuery<?> criteriaQuery,
                         CriteriaBuilder criteriaBuilder,
                         SortingModel sorting) {
        if (sorting != null) {
            if (!Sort.Direction.ASC.equals(sorting.getOrder())) {
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sorting.getField())));
            } else {
                criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sorting.getField())));
            }
        }
    }
}
