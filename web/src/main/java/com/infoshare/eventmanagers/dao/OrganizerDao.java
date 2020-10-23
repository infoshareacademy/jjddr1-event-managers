package com.infoshare.eventmanagers.dao;


import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class OrganizerDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional






}
