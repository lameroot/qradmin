package com.qr.qradmin.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.qrhandshake.qrpos.domain.*;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTemplateDto {
    private Long id;
    private Long terminalId;
    private Long merchantId;
    private String terminalName;
    private String merchantName;
    private Long amount;
    private String name;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderTemplateDto{");
        sb.append("id=").append(id);
        sb.append(", terminalId=").append(terminalId);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", terminalName='").append(terminalName).append('\'');
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append(", amount=").append(amount);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
