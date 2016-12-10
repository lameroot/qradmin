package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.qrhandshake.qrpos.domain.User;

@Component
public class UserToDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        if (user == null) return null;
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setMerchantId(user.getMerchant().getId());
        userDto.setMerchantName(user.getMerchant().getName());
        userDto.setUserName(user.getUsername());
        userDto.setCreatedDate(user.getCreatedDate());
        userDto.setEnabled(user.isEnabled());
        userDto.setExpired(!user.isAccountNonExpired());
        userDto.setLocked(!user.isAccountNonLocked());
        userDto.getRoles().addAll(user.getAuthorities());

        return userDto;
    }
}
