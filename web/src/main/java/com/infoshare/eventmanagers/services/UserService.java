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
    UserDao userDao;


    @Transactional
    public boolean createUser(UserDto userDto) {


        PropertiesDto propertiesDto = new PropertiesDto();
        propertiesDto.setSortingOrder("organizator");
        propertiesDto.setDateFormat("dd-MM-yyyy");
        propertiesDto.setAscending(true);
        userDto.setPropertiesDto(propertiesDto);

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


}
