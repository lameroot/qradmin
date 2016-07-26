package com.qr.qradmin.service.dto;

import com.qr.qradmin.dto.entity.UserInfoDto;
import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.service.entity.UserInfoService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoDtoService {
    @Resource
    private ConversionService conversionService;
    @Resource
    private UserInfoService userInfoService;

    public ElementResponse getCurrentUserInfo() {
        return new ElementResponse<>(conversionService.convert(userInfoService.getCurrentUserInfo(), UserInfoDto.class));
    }
}
