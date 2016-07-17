package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserDto;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;
import ru.qrhandshake.qrpos.domain.Merchant;
import ru.qrhandshake.qrpos.domain.User;

import java.util.Date;
import java.util.List;

public class UserToDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User user) {
        if (user == null) return null;
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
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
