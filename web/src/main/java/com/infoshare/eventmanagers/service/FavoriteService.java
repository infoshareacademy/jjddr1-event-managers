package com.infoshare.eventmanagers.service;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.dto.OrganizerDto;
import com.infoshare.eventmanagers.dto.PlaceDto;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//To consider scope!!
@RequestScoped
public class FavoriteService {

    public static EventDto getFavorite(Integer id){

        EventDto eventDto = new EventDto();
        //Tu powinno być zapytanie do bazy danych o Event o podanym ID.
        //Na potrzeby testów jest to co poniżej:

        //Id:
        eventDto.setId(id);

        //Nazwa:
        //eventDto.setName("testName")

        //Miejsce:
        PlaceDto placeDto = new PlaceDto();
        placeDto.setName("testPlaceName");
        eventDto.setPlace(placeDto);

        //Organizator:
        OrganizerDto organizerDto = new OrganizerDto();
        organizerDto.setDesignation("testDesignation");
        eventDto.setOrganizer(organizerDto);

        //Data rozpoczęcia:
        LocalDateTime testStartDate = LocalDateTime.of(2020,02,02,02,02);
        eventDto.setStartDate(testStartDate);

        //Krótki opis:
        eventDto.setDescShort("testDescShort");

        return eventDto;
    }

    public static Map<String,Object> getMappedFavorite(Integer id){
        Map<String,Object> mappedFavorite = new HashMap<>();
        EventDto favorite = getFavorite(id);

        mappedFavorite.put("id",favorite.getId());
        //Hardcoded, bo Event nie ma pola Name.
        mappedFavorite.put("name","testName");
        mappedFavorite.put("place",favorite.getPlace().getName());
        mappedFavorite.put("organizer",favorite.getOrganizer().getDesignation());
        mappedFavorite.put("startDate",favorite.getStartDate());
        mappedFavorite.put("descShort",favorite.getDescShort());

        return mappedFavorite;
    }

}
