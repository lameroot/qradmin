package com.qr.qradmin.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr.qradmin.model.Filter;
import org.springframework.data.domain.Sort;

/**
 * Created by Smirnov_Y on 25.08.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageableFilterDto {
    private Integer page;
    private Integer limit;
    private Sort sort;
    private Filter filter;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }
}
