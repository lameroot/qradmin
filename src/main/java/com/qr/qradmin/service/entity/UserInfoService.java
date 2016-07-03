package com.qr.qradmin.service.entity;

import com.qr.qradmin.model.UserInfo;
import org.springframework.stereotype.Service;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import java.util.LinkedList;

@Service
public class UserInfoService {
    public UserInfo getCurrentUserInfo() {
        User currentUser = SecurityUtils.getCurrentUser();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(currentUser.getId());
        userInfo.setRoles(new LinkedList<>(currentUser.getAuthorities()));
        userInfo.setName(currentUser.getUsername());
        return userInfo;
    }
}
