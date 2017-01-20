package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.UserDto;
import com.qr.qradmin.dto.filter.UserFilterDto;
import com.qr.qradmin.filter.UserFilter;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.UserDtoService;
import com.qr.qradmin.validator.entity.UserDtoValidator;
import com.qr.qradmin.validator.filter.UserFilterDtoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.domain.User;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collections;

@Controller
@RequestMapping("/api/user")
public class UserController extends GenericController<User, UserFilter, UserDto, UserFilterDto> {

    @PostConstruct
    public void init() {
        supportedOperations.put(CrudOperation.GET_ONE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.CREATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.UPDATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
    }

    @Resource
    private UserDtoService userDtoService;
    @Resource
    private UserDtoValidator userDtoValidator;
    @Resource
    private UserFilterDtoValidator userFilterDtoValidator;

    @Override
    protected Validator getEntityValidator() {
        return userDtoValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return userFilterDtoValidator;
    }

    @Override
    protected GenericDtoService<User, UserFilter, UserDto, UserFilterDto> getDtoService() {
        return userDtoService;
    }
}
