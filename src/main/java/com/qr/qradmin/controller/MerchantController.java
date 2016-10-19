package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.MerchantDto;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.MerchantDtoService;
import com.qr.qradmin.validator.entity.MerchantDtoValidator;
import com.qr.qradmin.validator.filter.MerchantFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.domain.Merchant;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

@Controller
@RequestMapping("/api/merchant")
public class MerchantController extends GenericController<Merchant, MerchantDto> {

    @PostConstruct
    public void init() {
        supportedOperations.put(CrudOperation.GET_ONE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.CREATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.UPDATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
    }

    @Resource
    private MerchantDtoService merchantDtoService;
    @Resource
    private MerchantDtoValidator merchantDtoValidator;
    @Resource
    private MerchantFilterDtoValidator merchantFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return merchantDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return merchantFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<Merchant, MerchantDto> getDtoService() {
        return merchantDtoService;
    }
}
