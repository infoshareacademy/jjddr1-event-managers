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

    public boolean doUsernameExists(String username) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(U) FROM User U WHERE U.username= :username", Long.class);
        Long doExists = query.setParameter("username", username).getSingleResult();

        return doExists > 0;
    }

    public boolean doEmailExists(String email) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(U) FROM User U WHERE U.email= :email", Long.class);
        Long doExists = query.setParameter("email", email).getSingleResult();

        return doExists > 0;
    }


    public User update(Integer id, User user) {
        User userToUpdate = entityManager.find(User.class, id);
       
// TODO: zrefaktorować metodę by robiła update na wsystkie pola.  Aktualna wersja zapewnia  funkcjonalność 

        User userUpdated = entityManager.find(User.class,id);
        userUpdated.setFavoriteList(user.getFavoriteList());
        User merge = entityManager.merge(userUpdated);
        return merge;
    }


    public boolean delete(Integer id) {
        User toRemove = entityManager.find(User.class, id);
        if (toRemove != null) {
            entityManager.remove(toRemove);
            return true;
        }
        return false;
    }

    public int loginUser(LoginUserDto loginUserDto) {
        int id = 0;

        try {
            User user = entityManager
                    .createQuery("SELECT U FROM User U WHERE U.username=:username", User.class)
                    .setParameter("username", loginUserDto.getUsername())
                    .getSingleResult();

            if (user.getPassword().equals(loginUserDto.getPassword())) {
                id = user.getId();
            }
        } catch (Exception ignored) {
                //Powinno logować do pliku ?
        }

        return id;

    }


}
