package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserDto;
import com.qr.qradmin.service.entity.MerchantService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.User;

import javax.annotation.Resource;

public class UserToEntityConverter implements Converter<UserDto, User> {

    @Resource
    private MerchantService merchantService;

    @Override
    public User convert(UserDto userDto) {
        if (userDto == null) return null;
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        if (userDto.getMerchantId() != null) {
            user.setMerchant(merchantService.get(userDto.getMerchantId()));
        }
        return user;
    }
}
