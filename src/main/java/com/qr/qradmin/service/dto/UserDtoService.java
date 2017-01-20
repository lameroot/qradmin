package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.UserDto;
import com.qr.qradmin.dto.filter.UserFilterDto;
import com.qr.qradmin.filter.UserFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.UserService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.User;

import javax.annotation.Resource;

@Service
public class UserDtoService extends GenericDtoService<User, UserFilter, UserDto, UserFilterDto> {

    @Resource
    private UserService userService;

    @Override
    protected Class<User> getEClass() {
        return User.class;
    }

    @Override
    protected Class<UserDto> getEDtoClass() {
        return UserDto.class;
    }

    @Override
    protected Class<UserFilter> getEFilterClass() {
        return UserFilter.class;
    }

    @Override
    protected GenericEntityService<User, UserFilter> getEntityService() {
        return userService;
    }
}
