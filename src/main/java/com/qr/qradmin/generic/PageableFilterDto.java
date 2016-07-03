package com.qr.qradmin.generic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Smirnov_Y on 25.08.2015.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageableFilterDto {
    private Long fromId;
    private Integer size;

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
