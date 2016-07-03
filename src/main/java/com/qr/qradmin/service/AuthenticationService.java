package com.qr.qradmin.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthenticationService {

    @Resource
    private AuthenticationManager authenticationManager;

    public boolean authenticate(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(login, password);

        try {
            Authentication auth = authenticationManager.authenticate(authentication);
            if (auth == null) {
                return false;
            } else {
                SecurityContextHolder.getContext().setAuthentication(auth);
                return true;
            }
        } catch (AuthenticationException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
