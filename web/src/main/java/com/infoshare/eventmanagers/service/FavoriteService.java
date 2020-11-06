package com.infoshare.eventmanagers.service;

import com.infoshare.eventmanagers.dao.Dao;
import com.infoshare.eventmanagers.dao.EventDao;
import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//To consider scope!!
@RequestScoped
public class FavoriteService {

    @Inject
    Dao<User> userDao;
    @Inject
    EventDao eventDao;

    public EventDto getFavorite(Integer userId, Integer favoriteId){

        UserDto userDto = UserDto.toUserDto(userDao.getById(userId));

        List<EventDto> favoriteList = userDto.getFavoriteList();
        EventDto favorite = favoriteList.stream()
                .filter(eventDto -> eventDto.getId().equals(favoriteId))
                .findFirst()
                .orElse(null);

        return favorite;
    }

    public Map<String,Object> getMappedFavorite(Integer userId, Integer favoriteId){
        Map<String,Object> mappedFavorite = new HashMap<>();
        //EventDto favorite = getFavorite(userId,favoriteId);
        EventDto favorite = eventDao.getEvent(48268);
        if(favorite != null) {
            mappedFavorite.put("id", favorite.getId());
            mappedFavorite.put("name", favorite.getName());
            mappedFavorite.put("place", favorite.getPlace().getName());
            mappedFavorite.put("organizer", favorite.getOrganizer().getDesignation());
            mappedFavorite.put("startDate", favorite.getStartDate());
            mappedFavorite.put("descShort", favorite.getDescShort());
        } else {
            mappedFavorite.put("id","null");
            mappedFavorite.put("name", "null");
            mappedFavorite.put("place", "null");
            mappedFavorite.put("organizer", "null");
            mappedFavorite.put("startDate", "null");
            mappedFavorite.put("descShort", "null");
        }
        return mappedFavorite;
    }

}
