package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.UserDto;
import com.qr.qradmin.dto.filter.UserFilterDto;
import com.qr.qradmin.filter.UserFilter;
import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.model.FilterDto;
import com.qr.qradmin.service.entity.UserService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;

@Service
public class UserDtoService extends GenericDtoService<User, UserDto, UserFilterDto> {

    @Resource
    private UserService userService;

    public ElementResponse<UserDto> getCurrentUser() {
        return new ElementResponse<UserDto>(conversionService.convert(SecurityUtils.getCurrentUser(), UserDto.class));
    }

    @Override
    protected EntityFilter buildFilter(UserFilterDto filterDto) {
        UserFilter filter = new UserFilter();
        return filter;
    }

    @Override
    protected Class<User> getEClass() {
        return User.class;
    }

    @Override
    protected Class<UserDto> getEDtoClass() {
        return UserDto.class;
    }

    @Override
    protected GenericEntityService<User> getEntityService() {
        return userService;
    }
}
