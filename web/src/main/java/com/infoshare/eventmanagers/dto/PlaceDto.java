package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.models.Place;

public class PlaceDto {

    private Integer id;
    private String subName;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Place toPlace(PlaceDto placeDto) {
        Place place = new Place();
        place.setId(placeDto.getId());
        place.setName(placeDto.getName());
        place.setSubName(place.getSubName());
        return place;
    }

    public static PlaceDto toPlaceDto(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setSubName(place.getSubName());
        placeDto.setName(place.getName());
        return placeDto;
    }
}
