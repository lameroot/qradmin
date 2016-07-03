package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.User;

public class UserToDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        if (user == null) return null;
        UserDto userDto = new UserDto();
        userDto.setName(user.getUsername());
        return userDto;
    }
}
