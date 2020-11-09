package com.infoshare.eventmanagers.service;

import com.infoshare.eventmanagers.dao.Dao;
import com.infoshare.eventmanagers.dao.EventDao;
import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.dto.UserFavoritesDto;
import com.infoshare.eventmanagers.models.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Comparator;
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

    public EventDto getFavorite(Integer userId, Integer favoriteId) {
        UserFavoritesDto userFavoritesDto = UserFavoritesDto.toUserFavoritesDto(userDao.getById(userId));
        List<EventDto> favoriteList = userFavoritesDto.getFavoriteList();
        return favoriteList.stream()
                .filter(eventDto -> eventDto.getId().equals(favoriteId))
                .findFirst()
                .orElse(null);
    }

    public List<EventDto> getRange(Integer userId, Integer start, Integer range) {
        UserFavoritesDto userFavoritesDto = UserFavoritesDto.toUserFavoritesDto(userDao.getById(userId));
        List<EventDto> favoriteList = userFavoritesDto.getFavoriteList();
        favoriteList.sort(Comparator.comparing(EventDto::getStartDate));
        return favoriteList.subList(start, range);
    }

    public void addFavorite(Integer userId, Integer eventId) {
        UserFavoritesDto userFavoritesDto = UserFavoritesDto.toUserFavoritesDto(userDao.getById(userId));
        List<EventDto> favoriteList = userFavoritesDto.getFavoriteList();
        EventDto favorite = EventDto.toEventDto(eventDao.getById(eventId));
        favoriteList.add(favorite);
        userFavoritesDto.setFavoriteList(favoriteList);
        userDao.update(userId, UserFavoritesDto.toUser(userFavoritesDto));
    }

    public void removeFavorite(Integer userId, Integer favoriteId) {
        UserFavoritesDto userFavoritesDto = UserFavoritesDto.toUserFavoritesDto(userDao.getById(userId));
        List<EventDto> favoriteList = userFavoritesDto.getFavoriteList();
        EventDto favoriteToRemove = favoriteList.stream()
                .filter(eventDto -> eventDto.getId().equals(favoriteId))
                .findFirst()
                .orElse(null);
        favoriteList.remove(favoriteToRemove);
        userFavoritesDto.setFavoriteList(favoriteList);
        userDao.update(userId, UserFavoritesDto.toUser(userFavoritesDto));
    }
/*
    public Map<String,Object> getMappedFavorite(Integer userId, Integer favoriteId){
        Map<String,Object> mappedFavorite = new HashMap<>();
        EventDto favorite = getFavorite(userId,favoriteId);
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
*/
}
