package com.infoshare.eventmanagers.dao;


import com.infoshare.eventmanagers.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDao implements Dao<User> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return entityManager.find(User.class, user.getId());
    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User update(Integer id, User user) {
        User userUpdated = new User();
        userUpdated.setFavoriteList(user.getFavoriteList());
        return userUpdated;
    }

    @Override
    public void delete(Integer id) {

    }
}
