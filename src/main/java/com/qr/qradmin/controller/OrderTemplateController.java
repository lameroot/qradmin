package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.OrderTemplateDto;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.OrderTemplateDtoService;
import com.qr.qradmin.validator.entity.OrderTemplateDtoValidator;
import com.qr.qradmin.validator.filter.OrderTemplateFilterDtoValidator;
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
public class OrderTemplateController extends GenericController<OrderTemplate, OrderTemplateDto> {

    @PostConstruct
    public void init() {
        supportedOperations.put(CrudOperation.GET_ONE, Collections.emptyList());
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.emptyList());
        supportedOperations.put(CrudOperation.CREATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.UPDATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.DELETE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
    }

    @Resource
    private OrderTemplateDtoService orderTemplateDtoService;
    @Resource
    private OrderTemplateDtoValidator orderTemplateDtoValidator;
    @Resource
    private OrderTemplateFilterDtoValidator orderTemplateFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return orderTemplateDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return orderTemplateFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<OrderTemplate, OrderTemplateDto> getDtoService() {
        return orderTemplateDtoService;
    }
}