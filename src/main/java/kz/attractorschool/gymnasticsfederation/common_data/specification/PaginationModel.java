package kz.attractorschool.gymnasticsfederation.common_data.specification;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
public class PaginationModel {
    private int page = 0;
    private int size = 5;

    public PageRequest getPageRequest() {
       return PageRequest.of(page, size);
    }
}
