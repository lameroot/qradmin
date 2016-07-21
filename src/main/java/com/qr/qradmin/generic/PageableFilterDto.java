package com.qr.qradmin.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Smirnov_Y on 25.08.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageableFilterDto {
    private Integer page;
    private Integer limit;

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
}
