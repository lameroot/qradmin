package com.qr.qradmin.dto.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qr.qradmin.generic.PageableFilterDto;
import ru.qrhandshake.qrpos.domain.*;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantOrderFilterDto {
    private Long id;
    private String orderId;
    private String externalId;
    private String externalOrderStatus;
    private Date paymentDateFrom;
    private Date paymentDateTo;
    private Date createdDateFrom;
    private Date createdDateTo;
    private Long amountFrom;
    private Long amountTo;
    private String deviceId;
    private Long merchantId;
    private Long terminalId;
    private Long clientId;
    private String sessionId;
//    private List<IntegrationSupport> integrationSupports;
//    private List<OrderStatus> orderStatuses;
//    private List<PaymentSecureType> paymentSecureTypes;
//    private List<PaymentWay> paymentWays;
//    private List<PaymentType> paymentTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalOrderStatus() {
        return externalOrderStatus;
    }

    public void setExternalOrderStatus(String externalOrderStatus) {
        this.externalOrderStatus = externalOrderStatus;
    }

    public Date getPaymentDateFrom() {
        return paymentDateFrom;
    }

    public void setPaymentDateFrom(Date paymentDateFrom) {
        this.paymentDateFrom = paymentDateFrom;
    }

    public Date getPaymentDateTo() {
        return paymentDateTo;
    }

    public void setPaymentDateTo(Date paymentDateTo) {
        this.paymentDateTo = paymentDateTo;
    }

    public Date getCreatedDateFrom() {
        return createdDateFrom;
    }

    public void setCreatedDateFrom(Date createdDateFrom) {
        this.createdDateFrom = createdDateFrom;
    }

    public Date getCreatedDateTo() {
        return createdDateTo;
    }

    public void setCreatedDateTo(Date createdDateTo) {
        this.createdDateTo = createdDateTo;
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

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

//    public List<IntegrationSupport> getIntegrationSupports() {
//        return integrationSupports;
//    }
//
//    public void setIntegrationSupports(List<IntegrationSupport> integrationSupports) {
//        this.integrationSupports = integrationSupports;
//    }
//
//    public List<OrderStatus> getOrderStatuses() {
//        return orderStatuses;
//    }
//
//    public void setOrderStatuses(List<OrderStatus> orderStatuses) {
//        this.orderStatuses = orderStatuses;
//    }
//
//    public List<PaymentSecureType> getPaymentSecureTypes() {
//        return paymentSecureTypes;
//    }
//
//    public void setPaymentSecureTypes(List<PaymentSecureType> paymentSecureTypes) {
//        this.paymentSecureTypes = paymentSecureTypes;
//    }
//
//    public List<PaymentWay> getPaymentWays() {
//        return paymentWays;
//    }
//
//    public void setPaymentWays(List<PaymentWay> paymentWays) {
//        this.paymentWays = paymentWays;
//    }
//
//    public List<PaymentType> getPaymentTypes() {
//        return paymentTypes;
//    }
//
//    public void setPaymentTypes(List<PaymentType> paymentTypes) {
//        this.paymentTypes = paymentTypes;
//    }
}
