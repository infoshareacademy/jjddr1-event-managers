package com.infoshare.eventmanagers.services;

import com.infoshare.eventmanagers.dao.Dao;
import com.infoshare.eventmanagers.dao.UserDao;
import com.infoshare.eventmanagers.dto.LoginUserDto;
import com.infoshare.eventmanagers.dto.PropertiesDto;
import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class UserService {

    @Inject
    UserDao userDao;


    @Transactional
    public boolean createUser(UserDto userDto) {


        if (userDto.getPropertiesDto() == null) {
            userDto.setPropertiesDto(PropertiesDto.getDefaultPropertiesDto());
        }
        userDao.save(UserDto.toUser(userDto));
       return true;
    }


    @Transactional
    public boolean checkEmail(String email) {
        return userDao.isEmailExists(email);
    }

    @Transactional
    public boolean checkUsername(String username) {
        return userDao.isUsernameExists(username);

    }

    @Transactional
    public UserDto getById(Integer id) {
        return UserDto.toUserDto(userDao.getById(id));
    }

    @Transactional
    public void updateUser(Integer id, UserDto userDto) {
        userDao.update(id, UserDto.toUser(userDto));
    }

    @Transactional
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }

    @Transactional
    public int loginUser(LoginUserDto loginUser) {
        return userDao.loginUser(loginUser);
    }


}
