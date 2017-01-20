package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.dto.filter.OrderTemplateFilterDto;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.OrderTemplateService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.OrderTemplate;

import javax.annotation.Resource;

@Service
public class OrderTemplateDtoService extends GenericDtoService<OrderTemplate, OrderTemplateFilter, OrderTemplateDto, OrderTemplateFilterDto> {

    @Resource
    private OrderTemplateService orderTemplateService;

    @Override
    protected Class<OrderTemplate> getEClass() {
        return OrderTemplate.class;
    }

    @Override
    protected Class<OrderTemplateDto> getEDtoClass() {
        return OrderTemplateDto.class;
    }

    @Override
    protected Class<OrderTemplateFilter> getEFilterClass() {
        return OrderTemplateFilter.class;
    }

    @Override
    protected GenericEntityService<OrderTemplate, OrderTemplateFilter> getEntityService() {
        return orderTemplateService;
    }
}
