package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.MerchantOrderService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.MerchantOrder;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class MerchantOrderDtoService extends GenericDtoService<MerchantOrder, MerchantOrderDto, MerchantOrderFilterDto> {

    @Resource
    private MerchantOrderService merchantOrderService;

    @Override
    protected EntityFilter buildFilter(MerchantOrderFilterDto filter) {
        MerchantOrderFilter entityFilter = new MerchantOrderFilter();

        if (!SecurityUtils.isCurrentUserAdmin()) {
            User user = SecurityUtils.getCurrentUser();
            entityFilter.setMerchantId(user.getMerchant().getId());
        }

        if (filter == null) {
            return entityFilter;
        }

        entityFilter.setId(filter.getId());
        entityFilter.setOrderId(filter.getOrderId());
        entityFilter.setExternalId(filter.getExternalId());
        entityFilter.setExternalOrderStatus(filter.getExternalOrderStatus());

//        entityFilter.setCreatedDateFrom(filter.get("id"));
//        entityFilter.setCreatedDateTo(filter.get("id"));

//        entityFilter.setPaymentDateFrom(filter.get("id"));
//        entityFilter.setPaymentDateTo(filter.get("id"));

        entityFilter.setAmountFrom(filter.getAmountFrom());
        entityFilter.setAmountTo(filter.getAmountTo());

        entityFilter.setDeviceId(filter.getDeviceId());
//        entityFilter.setMerchantId(filter.get("id"));
//        entityFilter.setTerminalId(filter.get("id"));
//        entityFilter.setClientId(filter.get("id"));
        entityFilter.setSessionId(filter.getSessionId());

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
