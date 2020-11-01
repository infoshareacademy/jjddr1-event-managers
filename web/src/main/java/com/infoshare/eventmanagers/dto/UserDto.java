package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.models.Place;
import com.infoshare.eventmanagers.models.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Integer id;
    private List<EventDto> favoriteList;

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


    public static UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFavoriteList(user.getFavoriteList().stream().map(event -> EventDto.toEventDto(event)).collect(Collectors.toList()));
        return userDto;
    }

    public static User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFavoriteList(userDto.getFavoriteList().stream().map(eventDto -> EventDto.toEvent(eventDto)).collect(Collectors.toList()));
        return user;
    }

}
