package com.qr.qradmin.filter;

import com.qr.qradmin.generic.EntityFilter;
import ru.qrhandshake.qrpos.domain.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Smirnov_Y on 28.11.2014.
 */
public class OrderTemplateFilter extends EntityFilter {
    private Long terminalId;
    private String name;
    private Long amountFrom;
    private Long amountTo;

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
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
