package com.infoshare.eventmanagers.dao;


public interface Dao<T> {
    T getById(Integer id);

    T save(T t);

    T update(Integer id, T t);

    boolean delete(Integer id);

}
