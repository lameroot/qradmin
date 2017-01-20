package com.qr.qradmin.converter;

import com.qr.qradmin.dto.filter.MerchantOrderFilterDto;
import com.qr.qradmin.filter.MerchantOrderFilter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

@Component
public class MerchantOrderFilterConverter implements Converter<MerchantOrderFilterDto, MerchantOrderFilter> {

    @Override
    public MerchantOrderFilter convert(MerchantOrderFilterDto filterDto) {
        if (filterDto == null) return null;
        MerchantOrderFilter filter = new MerchantOrderFilter();

        if (!SecurityUtils.isCurrentUserAdmin()) {
            User user = SecurityUtils.getCurrentUser();
            filter.setMerchantId(user.getMerchant().getId());
        }

        if (filter == null) {
            return filter;
        }

        filter.setId(filter.getId());
        filter.setOrderId(filter.getOrderId());
        filter.setExternalId(filter.getExternalId());
        filter.setExternalOrderStatus(filter.getExternalOrderStatus());

//        filter.setCreatedDateFrom(filter.get("id"));
//        filter.setCreatedDateTo(filter.get("id"));

//        filter.setPaymentDateFrom(filter.get("id"));
//        filter.setPaymentDateTo(filter.get("id"));

        filter.setAmountFrom(filter.getAmountFrom());
        filter.setAmountTo(filter.getAmountTo());

        filter.setDeviceId(filter.getDeviceId());
//        filter.setMerchantId(filter.get("id"));
//        filter.setTerminalId(filter.get("id"));
//        filter.setClientId(filter.get("id"));
        filter.setSessionId(filter.getSessionId());

//        filter.setIntegrationSupports(filterDto.getIntegrationSupports());
//        filter.setOrderStatuses(filterDto.getOrderStatuses());
//        filter.setPaymentSecureTypes(filterDto.getPaymentSecureTypes());
//        filter.setPaymentWays(filterDto.getPaymentWays());
//        filter.setPaymentTypes(filterDto.getPaymentTypes());
        return filter;
    }
}
