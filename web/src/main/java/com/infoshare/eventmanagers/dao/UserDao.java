package com.infoshare.eventmanagers.dao;


import com.infoshare.eventmanagers.dto.LoginUserDto;
import com.infoshare.eventmanagers.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.SQLException;

@Stateless
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public User save(User user) {
        entityManager.persist(user);
        return entityManager.find(User.class, user.getId());
    }


    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public boolean isUsernameExists(String username) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(U) FROM User U WHERE U.username= :username", Long.class);
        Long isExists = query.setParameter("username", username).getSingleResult();

        return isExists > 0;
    }

    public boolean isEmailExists(String email) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(U) FROM User U WHERE U.email= :email", Long.class);
        Long isExists = query.setParameter("email", email).getSingleResult();

        return isExists > 0;
    }


    public User update(Integer id, User user) {
        User userToUpdated = entityManager.find(User.class, id);
//        if (userToUpdated != null) {
//            if (!userToUpdated.getEmail().equals(user.getEmail())) {
//                userToUpdated.setEmail(user.getEmail());
//            }
//            if (!userToUpdated.getFavoriteList().equals(user.getFavoriteList())) {
//                userToUpdated.setFavoriteList(user.getFavoriteList());
//            }
//            if (!userToUpdated.getPassword().equals(user.getPassword())) {
//                userToUpdated.setPassword(user.getPassword());
//            }
//            if (!userToUpdated.getProperties().equals(user.getProperties())) {
//                userToUpdated.setProperties(user.getProperties());
//            }
//            return entityManager.merge(userToUpdated);

//        }
        return null;

    }


    public boolean delete(Integer id) {
        User toRemove = entityManager.find(User.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public boolean loginUser(LoginUserDto loginUserDto) {


        User user = entityManager
                .createQuery("SELECT U FROM User U WHERE U.username=:username", User.class)
                .setParameter("username", loginUserDto)
                .getSingleResult();

        if (user.getPassword().equals(loginUserDto.getPassword())) {
            return true;
        }

        return false;

    }

    public int getId(String username) {
        return entityManager.createQuery("SELECT U.id FROM User U WHERE U.username=:username").setParameter("username", username).getFirstResult();
    }

    public boolean checkPassword(String password) {
        return entityManager.createQuery("SELECT COUNT (u) FROM User u WHERE I")
    }
}
