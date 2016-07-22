package com.qr.qradmin.generic;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Smirnov_Y on 02.12.2014.
 */
public class PageResponse<EDto> extends Response {
    private long total;
    private List<EDto> data = new LinkedList<>();

    public PageResponse(List<EDto> data, long total) {
        this.data = data;
        this.total = total;
    }

    public List<EDto> getData() {
        return data;
    }


    public long getTotal() {
        return total;
    }
}
