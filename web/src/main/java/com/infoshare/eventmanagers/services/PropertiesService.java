package com.infoshare.eventmanagers.services;

import com.infoshare.eventmanagers.dao.PropertiesDao;
import com.infoshare.eventmanagers.dto.PropertiesDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@RequestScoped
public class PropertiesService {

    @Inject
    PropertiesDao propertiesDao;

    @Transactional
    public void updateProperties(Integer id, PropertiesDto propertiesDto){
        propertiesDao.update(id, propertiesDto.toProperties(propertiesDto));
    }

}
