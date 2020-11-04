package com.infoshare.eventmanagers.services;

import com.infoshare.eventmanagers.dao.Dao;
import com.infoshare.eventmanagers.dto.PropertiesDto;
import com.infoshare.eventmanagers.models.Properties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class PropertiesService {

    @Inject
    Dao<Properties> propertiesDao;

    @Transactional
    public void createProperties(PropertiesDto propertiesDto) {
        Properties properties = PropertiesDto.toProperties(propertiesDto);
        propertiesDao.save(properties);
    }

    @Transactional
    public PropertiesDto readProperties(Integer id) {
        return PropertiesDto.toPropertiesDto(propertiesDao.getById(id));
    }

    @Transactional
    public void updateProperties(Integer id, PropertiesDto propertiesDto){
        propertiesDao.update(id, propertiesDto.toProperties(propertiesDto));
    }

    @Transactional
    public void deleteProperties(Integer id) {
        propertiesDao.delete(id);
    }

}
