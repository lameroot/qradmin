package com.qr.qradmin.generic;

import javax.validation.constraints.NotNull;

/**
 * Created by Smirnov_Y on 26.06.2015.
 */
public abstract class EntityFilter {
    private Long fromId;
    private Integer count;

    public EntityFilter() {
    }

    public EntityFilter(@NotNull PageableFilterDto pageableFilterDto) {
        this.fromId = pageableFilterDto.getFromId();
        this.count = pageableFilterDto.getSize();
    }

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
