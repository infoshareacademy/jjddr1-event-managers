package com.infoshare.eventmanagers.dao;

import com.infoshare.eventmanagers.models.Properties;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PropertiesDao implements Dao<Properties> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Properties save(Properties properties) {
        entityManager.persist(properties);
        return entityManager.find(Properties.class, properties.getId());
    }

    @Override
    public Properties getById(Integer id) {
        Properties properties = entityManager.find(Properties.class, id);
        return properties;
    }

    @Override
    public Properties update(Integer id, Properties properties) {
        Properties propertiesUpdated = entityManager.find(Properties.class, id);
        propertiesUpdated.setDateFormat(properties.getDateFormat());
        propertiesUpdated.setSortingOrder(properties.getSortingOrder());
        propertiesUpdated.setAscending(properties.isAscending());
        return propertiesUpdated;
    }

    @Override
    public void delete(Integer id) {
        Properties toDelete = entityManager.find(Properties.class, id);
        entityManager.remove(toDelete);
    }

}
