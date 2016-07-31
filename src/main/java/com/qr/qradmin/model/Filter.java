package com.qr.qradmin.model;


import java.util.Map;

public class Filter {
    private Map<String, String> filters;

    public Filter(Map<String, String> filters) {
        this.filters = filters;
    }

    public Map<String, String> getFilters() {
        return filters;
    }
}
