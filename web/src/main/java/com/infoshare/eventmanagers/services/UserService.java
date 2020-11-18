package com.infoshare.eventmanagers.services;

import com.infoshare.eventmanagers.dao.Dao;
import com.infoshare.eventmanagers.dao.UserDao;
import com.infoshare.eventmanagers.dto.PropertiesDto;
import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class UserService {

    @Inject
    Dao<User> userDao;

    @Transactional
    public void createUser(UserDto userDto) {

        if(userDto.getPropertiesDto() == null) {
            userDto.setPropertiesDto(PropertiesDto.getDefaultPropertiesDto());
        }
        User user = UserDto.toUser(userDto);
        userDao.save(user);
    }

    @Transactional
    public UserDto getById(Integer id ){
       return UserDto.toUserDto(userDao.getById(id));
    }

    @Transactional
    public void updateUser(Integer id, UserDto userDto){
        userDao.update(id, UserDto.toUser(userDto));
    }

    @Transactional
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }



}
