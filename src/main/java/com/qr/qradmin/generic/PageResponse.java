package com.qr.qradmin.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Smirnov_Y on 02.12.2014.
 */
public class PageResponse<EDto> extends Response {
    private List<EDto> data = new LinkedList<>();
    private boolean hasMore;
    private long total;

    public PageResponse(List<EDto> data, boolean hasMore, long total) {
        this.data = data;
        this.hasMore = hasMore;
        this.total = total;
    }

    public List<EDto> getData() {
        return data;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public long getTotal() {
        return total;
    }
}
