package com.qr.qradmin.controller;

import com.qr.qradmin.dto.entity.UserDto;
import com.qr.qradmin.dto.filter.UserFilterDto;
import com.qr.qradmin.generic.CrudOperation;
import com.qr.qradmin.generic.GenericController;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.service.dto.UserDtoService;
import com.qr.qradmin.validator.entity.UserValidator;
import com.qr.qradmin.validator.filter.UserFilterValidator;
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
public class UserController extends GenericController<User, UserDto, UserFilterDto> {

    @PostConstruct
    public void init(){
        supportedOperations.put(CrudOperation.GET_ONE, Collections.emptyList());
        supportedOperations.put(CrudOperation.GET_SEVERAL, Collections.emptyList());
        supportedOperations.put(CrudOperation.CREATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.UPDATE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
        supportedOperations.put(CrudOperation.DELETE, Collections.singletonList(EnumGrantedAuthority.ADMIN));
    }

    @Resource
    private UserDtoService userDtoService;
    @Resource
    private UserValidator userValidator;
    @Resource
    private UserFilterValidator userFilterValidator;

    @Override
    protected Validator getEntityValidator() {
        return userValidator;
    }

    @Override
    protected Validator getFilterValidator() {
        return userFilterValidator;
    }

    @Override
    protected GenericDtoService<User, UserDto, UserFilterDto> getDtoService() {
        return userDtoService;
    }
}
