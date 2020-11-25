package com.infoshare.eventmanagers.dto;


import com.infoshare.eventmanagers.models.User;

public class UserPropertiesDto {

    private Integer id;
    private PropertiesDto propertiesDto;

    public UserPropertiesDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PropertiesDto getPropertiesDto() {
        return propertiesDto;
    }

    public void setPropertiesDto(PropertiesDto propertiesDto) {
        this.propertiesDto = propertiesDto;
    }

    public static UserDto toUserDto(UserPropertiesDto userPropertiesDto) {
        UserDto userDto = new UserDto();
        userDto.setId(userDto.getId());
        userDto.setPropertiesDto(userPropertiesDto.getPropertiesDto());
        return userDto;
    }

}
