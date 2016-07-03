package com.qr.qradmin.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qr.qradmin.enums.ErrorCode;
import com.qr.qradmin.service.ErrorService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFailedHandler implements AuthenticationFailureHandler {
    @Resource
    private ErrorService errorsService;
    @Resource
    private ObjectMapper objectMapper;

    private String errorMessage;

    @PostConstruct
    public void init() throws JsonProcessingException {
        errorMessage = objectMapper.writeValueAsString(errorsService.generateErrorResponse(ErrorCode.WRONG_AUTHORISATION_DATA));
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().print(errorMessage);
    }
}
