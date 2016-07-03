package com.qr.qradmin.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Smirnov_Y on 02.12.2014.
 */
public class PageResponse<EDto> extends Response {
    private List<EDto> data = new LinkedList<>();
    private boolean hasMore;

    public PageResponse(List<EDto> data, boolean hasMore) {
        this.data = data;
        this.hasMore = hasMore;
    }

    public List<EDto> getData() {
        return data;
    }

    public void setData(List<EDto> data) {
        this.data = data;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
