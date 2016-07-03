package com.qr.qradmin.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AuthFilter extends AbstractAuthenticationProcessingFilter {

    ObjectMapper objectMapper;

    protected AuthFilter(String defaultFilterProcessesUrl, ObjectMapper objectMapper) {
        super(defaultFilterProcessesUrl);
        this.objectMapper = objectMapper;
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return !"OPTIONS".equals(request.getMethod()) && super.requiresAuthentication(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
        if (StringUtils.isBlank(body)) throw new BadCredentialsException("Authentication data is empty");
        Map auth = objectMapper.readValue(body, Map.class);
        String login = (String) auth.get("login");
        String password = (String) auth.get("password");
        if (StringUtils.isBlank(login)) throw new BadCredentialsException("login is empty");
        if (StringUtils.isBlank(password)) throw new BadCredentialsException("password is empty");
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(login, password);
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
        response.setStatus(HttpServletResponse.SC_OK);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
