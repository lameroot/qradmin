package com.qr.qradmin.model;

import java.util.List;

public class Filter {
    private List<SingleFilter> filters;

    public Filter(List<SingleFilter> filters) {
        this.filters = filters;
    }

    public List<SingleFilter> getFilters() {
        return filters;
    }

    public class SingleFilter {
        private String property;
        private String value;

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
