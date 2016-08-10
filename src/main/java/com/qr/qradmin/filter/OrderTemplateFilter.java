package com.qr.qradmin.filter;

import com.qr.qradmin.generic.EntityFilter;
import ru.qrhandshake.qrpos.domain.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Smirnov_Y on 28.11.2014.
 */
public class OrderTemplateFilter extends EntityFilter {
    private Long terminal_id;
    private Long merchant_id;
    private Long amountFrom;
    private Long amountTo;

    public Long getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(Long terminal_id) {
        this.terminal_id = terminal_id;
    }

    public Long getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(Long merchant_id) {
        this.merchant_id = merchant_id;
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
