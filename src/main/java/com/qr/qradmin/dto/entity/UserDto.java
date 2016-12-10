package com.qr.qradmin.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private long id;
    private Long merchantId;
    private String merchantName;
    private String userName;
    private String password;
    private Date createdDate;
    private Boolean isEnabled;
    private Boolean isExpired;
    private Boolean isLocked;
    private List<EnumGrantedAuthority> roles = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
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

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public List<EnumGrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<EnumGrantedAuthority> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", merchantName='").append(merchantName).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", isExpired=").append(isExpired);
        sb.append(", isLocked=").append(isLocked);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
