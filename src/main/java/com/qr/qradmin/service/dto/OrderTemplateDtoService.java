package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.OrderTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qrhandshake.qrpos.domain.OrderTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderTemplateDtoService extends GenericDtoService<OrderTemplate, OrderTemplateDto> {

    @Resource
    private OrderTemplateService orderTemplateService;

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        OrderTemplateFilter entityFilter = new OrderTemplateFilter();
        if (CollectionUtils.isEmpty(filter)) {
            return entityFilter;
        }
        entityFilter.setAmountFrom(Optional.ofNullable(filter.get("amountFrom")).map(Long::valueOf).orElse(null));
        entityFilter.setAmountTo(Optional.ofNullable(filter.get("amountTo")).map(Long::valueOf).orElse(null));

        entityFilter.setMerchant_id(Optional.ofNullable(filter.get("merchantId")).map(Long::valueOf).orElse(null));
        entityFilter.setMerchant_id(Optional.ofNullable(filter.get("terminalId")).map(Long::valueOf).orElse(null));
        return entityFilter;
    }

    @Override
    protected Class<OrderTemplate> getEClass() {
        return OrderTemplate.class;
    }

    @Override
    protected Class<OrderTemplateDto> getEDtoClass() {
        return OrderTemplateDto.class;
    }

    @Override
    protected GenericEntityService<OrderTemplate> getEntityService() {
        return orderTemplateService;
    }
}
