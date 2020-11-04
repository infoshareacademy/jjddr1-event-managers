package com.infoshare.eventmanagers.services;

import com.infoshare.eventmanagers.dao.Dao;
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

        PropertiesDto propertiesDto = new PropertiesDto();
        propertiesDto.setSortingOrder("organizator");
        propertiesDto.setDateFormat("dd-MM-yyyy");
        propertiesDto.setAscending(true);

        userDto.setPropertiesDto(propertiesDto);
        User user = UserDto.toUser(userDto);
        userDao.save(user);
    }

    @Transactional
    public void updateUser(Integer id, UserDto userDto){
        userDao.update(id, userDto.toUser(userDto));
    }

    @Transactional
    public void deleteUser(Integer id) {
        userDao.delete(id);
    }



}
