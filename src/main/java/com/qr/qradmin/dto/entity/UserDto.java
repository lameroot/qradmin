package com.qr.qradmin.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private long id;
    private String merchantName;
    private String userName;
    private Date createdDate;
    private boolean isEnabled;
    private boolean isExpired;
    private boolean isLocked;
    private List<EnumGrantedAuthority> roles = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public List<EnumGrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<EnumGrantedAuthority> roles) {
        this.roles = roles;
    }
}
