package com.qr.qradmin.controller;

import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.service.dto.UserInfoDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/info")
public class InfoController {
    @Resource
    private UserInfoDtoService userInfoDtoService;

    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public ElementResponse getUserInfo() {
        return userInfoDtoService.getCurrentUserInfo();
    }
}
