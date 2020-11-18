package com.infoshare.eventmanagers.dao;

import com.infoshare.eventmanagers.models.Properties;
import com.infoshare.eventmanagers.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PropertiesDao {

    @PersistenceContext
    EntityManager entityManager;

    public Properties update(Integer id, Properties properties) {
        Properties propertiesUpdated = entityManager.find(Properties.class, id);
        propertiesUpdated.setDateFormat(properties.getDateFormat());
        propertiesUpdated.setSortingOrder(properties.getSortingOrder());
        propertiesUpdated.setAscending(properties.isAscending());
        return propertiesUpdated;
    }

}
