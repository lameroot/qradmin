package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.MerchantOrderDto;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.MerchantOrderDtoService;
import com.qr.qradmin.validator.entity.MerchantOrderDtoValidator;
import com.qr.qradmin.validator.filter.MerchantOrderFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.domain.MerchantOrder;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

@Controller
@RequestMapping("/api/order")
public class OrderController extends GenericController<MerchantOrder, MerchantOrderDto> {

    @PostConstruct
    public void init() {
        supportedOperations.put(CrudOperation.GET_ONE, Collections.emptyList());
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.emptyList());
        supportedOperations.put(CrudOperation.CREATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.UPDATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.DELETE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
    }

    @Resource
    private MerchantOrderDtoService merchantOrderDtoService;
    @Resource
    private MerchantOrderDtoValidator merchantOrderDtoValidator;
    @Resource
    private MerchantOrderFilterDtoValidator merchantOrderFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return merchantOrderDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return merchantOrderFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<MerchantOrder, MerchantOrderDto> getDtoService() {
        return merchantOrderDtoService;
    }
}
