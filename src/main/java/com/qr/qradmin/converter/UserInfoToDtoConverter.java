package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserInfoDto;
import com.qr.qradmin.model.UserInfo;
import org.springframework.core.convert.converter.Converter;
import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;

import java.util.LinkedList;
import java.util.List;

public class UserInfoToDtoConverter implements Converter<UserInfo, UserInfoDto> {

    @Override
    public UserInfoDto convert(UserInfo userInfo) {
        if (userInfo == null) return null;
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setName(userInfo.getName());
        List<String> roles = new LinkedList<>();
        for (EnumGrantedAuthority authority : userInfo.getRoles()) {
            roles.add(authority.getAuthority());
        }
        userInfoDto.setRoles(roles);
        return userInfoDto;
    }
}
