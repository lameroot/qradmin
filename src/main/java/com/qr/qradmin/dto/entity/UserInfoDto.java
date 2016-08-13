package com.qr.qradmin.dto.entity;

import java.util.List;

public class UserInfoDto {
    private Long id;
    private String name;
    private List<String> roles;
    private List<Long> terminalIds;
    private long merchantId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getTerminalIds() {
        return terminalIds;
    }

    public void setTerminalIds(List<Long> terminalIds) {
        this.terminalIds = terminalIds;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }
}
