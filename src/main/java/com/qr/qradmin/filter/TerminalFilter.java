package com.qr.qradmin.filter;

import com.qr.qradmin.generic.EntityFilter;

import java.util.List;

/**
 * Created by Smirnov_Y on 28.11.2014.
 */
public class TerminalFilter extends EntityFilter {
    private List<Long> terminalIds;

    public List<Long> getTerminalIds() {
        return terminalIds;
    }

    public void setTerminalIds(List<Long> terminalIds) {
        this.terminalIds = terminalIds;
    }
}
