package com.qr.qradmin.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalDto {
    private Long id;
    private String merchantName;
    private Long merchantId;
    private String authName;
    private String authPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TerminalDto{");
        sb.append("id=").append(id);
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append(", merchantId=").append(merchantId);
        sb.append(", authName='").append(authName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
