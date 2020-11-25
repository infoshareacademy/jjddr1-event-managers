package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.models.User;
import com.infoshare.eventmanagers.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private List<EventDto> favoriteList;
    private PropertiesDto propertiesDto;

    public UserDto() {
    }

    public UserDto(String username, String password, String email) {
        this.username = username;
        this.password = Utils.encodePassword(password);
        this.email = email;
    }

    public PropertiesDto getPropertiesDto() {
        return propertiesDto;
    }

    public void setPropertiesDto(PropertiesDto propertiesDto) {
        this.propertiesDto = propertiesDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EventDto> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<EventDto> favoriteList) {
        this.favoriteList = favoriteList;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFavoriteList(user.getFavoriteList().stream().map(event -> EventDto.toEventDto(event)).collect(Collectors.toList()));
        return userDto;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setId(userDto.getId());
        user.setProperties(PropertiesDto.toProperties(userDto.getPropertiesDto()));
        user.setFavoriteList(new ArrayList<>());
        return user;
    }

}
