package com.infoshare.eventmanagers.dto;


import com.infoshare.eventmanagers.models.Properties;

public class PropertiesDto {

    private Integer id;
    private String sortingOrder;
    private boolean ascending;
    private String dateFormat;

    public static Properties toProperties(PropertiesDto propertiesDto) {
        Properties properties = new Properties();
        properties.setAscending(propertiesDto.isAscending());
        properties.setSortingOrder(propertiesDto.getSortingOrder());
        properties.setDateFormat(propertiesDto.getDateFormat());
        return properties;
    }

    public static PropertiesDto toPropertiesDto (Properties properties) {
        PropertiesDto propertiesDto = new PropertiesDto();
        propertiesDto.setAscending(properties.isAscending());
        propertiesDto.setDateFormat(properties.getDateFormat());
        propertiesDto.setSortingOrder(properties.getSortingOrder());
        return propertiesDto;
    }

    public static PropertiesDto getDefaultPropertiesDto() {
        PropertiesDto propertiesDto = new PropertiesDto();
        propertiesDto.setSortingOrder("organizator");
        propertiesDto.setDateFormat("dd-MM-yyyy");
        propertiesDto.setAscending(true);
        return propertiesDto;
    }

    public PropertiesDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
