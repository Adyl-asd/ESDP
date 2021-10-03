package kz.attractorschool.gymnasticsfederation.common_data.specification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchModel<T extends FilterModel> {

    private T filter;
    private SortingModel sort;
    private PaginationModel pagination;
}
