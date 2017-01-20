package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.dto.filter.OrderTemplateFilterDto;
import com.qr.qradmin.filter.OrderTemplateFilter;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.OrderTemplateDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.domain.OrderTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

@Controller
@RequestMapping("/api/orderTemplate")
public class OrderTemplateController extends GenericController<OrderTemplate, OrderTemplateFilter, OrderTemplateDto, OrderTemplateFilterDto> {

    @PostConstruct
    public void init() {
        supportedOperations.put(CrudOperation.GET_ONE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.emptyList());        //TODO сделать отдельный метод для получения своих записей
        supportedOperations.put(CrudOperation.CREATE, Collections.emptyList());
        supportedOperations.put(CrudOperation.UPDATE, Collections.emptyList());
    }

    @Resource
    private OrderTemplateDtoService orderTemplateDtoService;
    @Resource
    private Validator orderTemplateDtoValidator;
    @Resource
    private Validator orderTemplateFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return orderTemplateDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return orderTemplateFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<OrderTemplate, OrderTemplateFilter, OrderTemplateDto, OrderTemplateFilterDto> getDtoService() {
        return orderTemplateDtoService;
    }
}
