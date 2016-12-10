package com.qr.qradmin.converter;

import com.qr.qradmin.dto.entity.UserInfoDto;
import com.qr.qradmin.model.UserInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserInfoToDtoConverter implements Converter<UserInfo, UserInfoDto> {

    @Override
    public UserInfoDto convert(UserInfo userInfo) {
        if (userInfo == null) return null;
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(userInfo.getId());
        userInfoDto.setName(userInfo.getName());
        userInfoDto.setRoles(userInfo.getRoles().stream().map(Enum::name).collect(Collectors.toList()));
        userInfoDto.setMerchantId(userInfo.getMerchantId());
        userInfoDto.setTerminalIds(userInfo.getTerminalIds());
        return userInfoDto;
    }
}
