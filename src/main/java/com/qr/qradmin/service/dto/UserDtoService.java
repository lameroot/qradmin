package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.UserDto;
import com.qr.qradmin.filter.UserFilter;
import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.generic.EntityFilter;
import com.qr.qradmin.generic.GenericDtoService;
import com.qr.qradmin.generic.GenericEntityService;
import com.qr.qradmin.service.entity.UserService;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserDtoService extends GenericDtoService<User, UserDto> {

    @Resource
    private UserService userService;

    public ElementResponse<UserDto> getCurrentUser() {
        return new ElementResponse<>(conversionService.convert(SecurityUtils.getCurrentUser(), UserDto.class));
    }

    @Override
    protected EntityFilter buildFilter(Map<String, String> filter) {
        UserFilter entityFilter = new UserFilter();
        return entityFilter;
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
