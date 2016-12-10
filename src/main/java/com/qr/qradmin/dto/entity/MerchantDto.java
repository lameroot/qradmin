package com.qr.qradmin.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.qrhandshake.qrpos.domain.IntegrationSupport;

import java.util.Date;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDto {
    private Long id;
    private String name;
    private String description;
    private Date createdDate;
    private IntegrationSupport integrationSupport;
    private Set<Long> terminalIds;
    private Set<Long> userIds;
    private boolean createBinding;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public IntegrationSupport getIntegrationSupport() {
        return integrationSupport;
    }

    public void setIntegrationSupport(IntegrationSupport integrationSupport) {
        this.integrationSupport = integrationSupport;
    }

    public Set<Long> getTerminalIds() {
        return terminalIds;
    }

    public void setTerminalIds(Set<Long> terminalIds) {
        this.terminalIds = terminalIds;
    }

    public Set<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(Set<Long> userIds) {
        this.userIds = userIds;
    }

    public boolean isCreateBinding() {
        return createBinding;
    }

    public void setCreateBinding(boolean createBinding) {
        this.createBinding = createBinding;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MerchantDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", createdDate=").append(createdDate);
        sb.append(", integrationSupport=").append(integrationSupport);
        sb.append('}');
        return sb.toString();
    }
}
