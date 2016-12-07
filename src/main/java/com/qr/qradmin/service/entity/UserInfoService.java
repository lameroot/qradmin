package com.qr.qradmin.service.entity;

import com.qr.qradmin.model.UserInfo;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.qrhandshake.qrpos.domain.Terminal;
import ru.qrhandshake.qrpos.domain.User;
import ru.qrhandshake.qrpos.util.SecurityUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserInfoService {

    @Resource
    private UserService userService;
    @Resource
    private ru.qrhandshake.qrpos.service.TerminalService terminalService;

    @Transactional(readOnly = true)
    public UserInfo getCurrentUserInfo() {
        User currentUser = SecurityUtils.getCurrentUser();
        if (currentUser == null) return null;

        currentUser = userService.get(currentUser.getId());
        Hibernate.initialize(currentUser.getMerchant());
        Set<Terminal> terminals = terminalService.findByMerchant(currentUser.getMerchant());

        UserInfo userInfo = new UserInfo();
        userInfo.setId(currentUser.getId());
        userInfo.setRoles(new LinkedList<>(currentUser.getAuthorities()));
        userInfo.setName(currentUser.getUsername());
        userInfo.setMerchantId(currentUser.getMerchant().getId());
        userInfo.setTerminalIds(terminals.stream().map(Terminal::getId).collect(Collectors.toList()));
        return userInfo;
    }
}
