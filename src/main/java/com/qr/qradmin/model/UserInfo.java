package com.qr.qradmin.model;

import ru.qrhandshake.qrpos.domain.EnumGrantedAuthority;

import java.util.List;

public class UserInfo {
    private Long id;
    private String name;
    private List<EnumGrantedAuthority> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EnumGrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(List<EnumGrantedAuthority> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
