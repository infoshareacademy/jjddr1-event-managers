package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.models.Properties;

public class UserPropertiesDto {

    private Integer id;
    private Properties properties;

    public UserPropertiesDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
