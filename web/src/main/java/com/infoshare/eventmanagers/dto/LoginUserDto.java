package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.utils.Utils;

public class LoginUserDto {

    private Integer id;
    private String username;
    private String password;

    public LoginUserDto(String username, String password) {
        this.username = username;
        this.password = Utils.encodePassword(password);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
