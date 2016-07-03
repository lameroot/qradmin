package com.qr.qradmin.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.generic.Response;
import org.springframework.security.core.Authentication;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    private String errorMessage;

    @Resource
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() throws JsonProcessingException {
        errorMessage = objectMapper.writeValueAsString(Response.SUCCESSFUL);
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.getWriter().print(errorMessage);
    }
}
