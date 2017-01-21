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
        MerchantOrderFilter filter = new MerchantOrderFilter();

        if (!SecurityUtils.isCurrentUserAdmin()) {
            User user = SecurityUtils.getCurrentUser();
            filter.setMerchantId(user.getMerchant().getId());
        }

        if (filterDto == null) {
            return filter;
        }

        filter.setId(filterDto.getId());
        filter.setOrderId(filterDto.getOrderId());
        filter.setExternalId(filterDto.getExternalId());
        filter.setExternalOrderStatus(filterDto.getExternalOrderStatus());

        filter.setAmountFrom(filterDto.getAmountFrom());
        filter.setAmountTo(filterDto.getAmountTo());

        filter.setDeviceId(filterDto.getDeviceId());
        filter.setSessionId(filterDto.getSessionId());

        return filter;
    }
}
