package com.qr.qradmin.filter;

import java.util.List;

/**
 * Created by Smirnov_Y on 28.11.2014.
 */
public class OrderTemplateFilter {
    private List<Long> terminalIds;
    private String name;
    private Long amountFrom;
    private Long amountTo;

    public List<Long> getTerminalIds() {
        return terminalIds;
    }

    public void setTerminalIds(List<Long> terminalIds) {
        this.terminalIds = terminalIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmountFrom() {
        return amountFrom;
    }

    public void setAmountFrom(Long amountFrom) {
        this.amountFrom = amountFrom;
    }

    public Long getAmountTo() {
        return amountTo;
    }

    public void setAmountTo(Long amountTo) {
        this.amountTo = amountTo;
    }
}
