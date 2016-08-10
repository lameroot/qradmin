package com.qr.qradmin.dto.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTemplateFilterDto {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderTemplateFilterDto{");
        sb.append("terminal_id=").append(terminal_id);
        sb.append(", merchant_id=").append(merchant_id);
        sb.append(", amountFrom=").append(amountFrom);
        sb.append(", amountTo=").append(amountTo);
        sb.append('}');
        return sb.toString();
    }
}
