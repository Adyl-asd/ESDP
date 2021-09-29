package kz.attractorschool.gymnasticsfederation.common_data.specification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class SortingModel {
    private String field;
    private Sort.Direction order = Sort.Direction.ASC;
}
