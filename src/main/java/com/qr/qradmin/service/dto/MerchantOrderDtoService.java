package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.MerchantOrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class MerchantOrderDtoService extends GenericDtoService<MerchantOrder, MerchantOrderDto> {

    @Resource
    private MerchantOrderService merchantOrderService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        MerchantOrderFilter entityFilter = new MerchantOrderFilter();
        if (CollectionUtils.isEmpty(filter)) {
            return entityFilter;
        }
        entityFilter.setId(Optional.ofNullable(filter.get("id")).map(Long::valueOf).orElse(null));
        entityFilter.setOrderId(filter.get("orderId"));
        entityFilter.setExternalId(filter.get("externalId"));
        entityFilter.setExternalOrderStatus(filter.get("externalOrderStatus"));

//        entityFilter.setCreatedDateFrom(filter.get("id"));
//        entityFilter.setCreatedDateTo(filter.get("id"));

//        entityFilter.setPaymentDateFrom(filter.get("id"));
//        entityFilter.setPaymentDateTo(filter.get("id"));

        entityFilter.setAmountFrom(Optional.ofNullable(filter.get("amountFrom")).map(Long::valueOf).orElse(null));
        entityFilter.setAmountTo(Optional.ofNullable(filter.get("amountTo")).map(Long::valueOf).orElse(null));

        entityFilter.setDeviceId(filter.get("deviceId"));
//        entityFilter.setMerchantId(filter.get("id"));
//        entityFilter.setTerminalId(filter.get("id"));
//        entityFilter.setClientId(filter.get("id"));
        entityFilter.setSessionId(filter.get("sessionId"));

//        filter.setIntegrationSupports(filterDto.getIntegrationSupports());
//        filter.setOrderStatuses(filterDto.getOrderStatuses());
//        filter.setPaymentSecureTypes(filterDto.getPaymentSecureTypes());
//        filter.setPaymentWays(filterDto.getPaymentWays());
//        filter.setPaymentTypes(filterDto.getPaymentTypes());
        return entityFilter;
    }

    @Override
    protected Class<MerchantOrder> getEClass() {
        return MerchantOrder.class;
    }

    @Override
    protected Class<MerchantOrderDto> getEDtoClass() {
        return MerchantOrderDto.class;
    }

    @Override
    protected GenericEntityService<MerchantOrder> getEntityService() {
        return merchantOrderService;
    }
}
