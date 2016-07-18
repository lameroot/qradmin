package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.User;

public class UserToEntityConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        if (userDto == null) return null;
        User user = new User();
        user.setUsername(userDto.getUserName());
        return user;
    }
}
