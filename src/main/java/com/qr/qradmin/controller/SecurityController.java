package com.qr.qradmin.controller;

import com.qr.qradmin.service.AuthenticationService;
import com.qr.qradmin.service.dto.UserInfoDtoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/security")
public class SecurityController {

    @Resource
    private UserInfoDtoService userInfoDtoService;
    @Resource
    private AuthenticationService authenticationService;

//    @RequestMapping(value = "/login", method= RequestMethod.POST)
//    @ResponseBody
//    public ElementResponse loginPost(@RequestBody AuthorisationDataDto authorisationData, HttpServletResponse response) {
//        boolean authenticated = authenticationService.authenticate(authorisationData.getLogin(), authorisationData.getPassword());
//        if (!authenticated) response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        return userInfoDtoService.getCurrentUserInfo();
//    }
//
//    @RequestMapping(value = "/logout", method= RequestMethod.POST)
//    @ResponseBody
//    public ElementResponse logoutPost(HttpServletResponse response) {
//        response.reset();
//        response.setStatus(HttpServletResponse.SC_OK);
//        return userInfoDtoService.getCurrentUserInfo();
//    }
}