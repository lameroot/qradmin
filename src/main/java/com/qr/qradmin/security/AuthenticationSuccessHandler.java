package com.qr.qradmin.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.generic.ElementResponse;
import com.qr.qradmin.model.UserInfo;
import com.qr.qradmin.service.dto.UserInfoDtoService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Resource
    private ObjectMapper objectMapper;
    @Resource
    private UserInfoDtoService userInfoDtoService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        clearAuthenticationAttributes(request);
        ElementResponse<UserInfo> resp = userInfoDtoService.getCurrentUserInfo();
        response.getWriter().print(objectMapper.writeValueAsString(resp));
    }
}
