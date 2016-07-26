package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.model.FilterDto;
import com.qr.qradmin.service.entity.MerchantOrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Optional;

@Service
public class MerchantOrderDtoService extends GenericDtoService<MerchantOrder, MerchantOrderDto, MerchantOrderFilterDto> {

    @Resource
    private MerchantOrderService merchantOrderService;

    @Override
    protected EntityFilter buildFilter(MerchantOrderFilterDto filterDto) {
        MerchantOrderFilter filter = new MerchantOrderFilter();
        filter.setId(filterDto.getId());
        filter.setOrderId(filterDto.getOrderId());
        filter.setExternalId(filterDto.getExternalId());
        filter.setExternalOrderStatus(filterDto.getExternalOrderStatus());

        filter.setCreatedDateFrom(filterDto.getCreatedDateFrom());
        filter.setCreatedDateTo(filterDto.getCreatedDateTo());

        filter.setPaymentDateFrom(filterDto.getPaymentDateFrom());
        filter.setPaymentDateTo(filterDto.getPaymentDateTo());

        filter.setAmountFrom(filterDto.getAmountFrom());
        filter.setAmountTo(filterDto.getAmountTo());

        filter.setDeviceId(filterDto.getDeviceId());
        filter.setMerchantId(filterDto.getMerchantId());
        filter.setTerminalId(filterDto.getTerminalId());
        filter.setClientId(filterDto.getClientId());
        filter.setSessionId(filterDto.getSessionId());

        filter.setIntegrationSupports(filterDto.getIntegrationSupports());
        filter.setOrderStatuses(filterDto.getOrderStatuses());
        filter.setPaymentSecureTypes(filterDto.getPaymentSecureTypes());
        filter.setPaymentWays(filterDto.getPaymentWays());
        filter.setPaymentTypes(filterDto.getPaymentTypes());
        return filter;
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
