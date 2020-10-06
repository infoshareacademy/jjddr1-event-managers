package com.infoshare.eventmanagers.repository;


import com.infoshare.eventmanagers.model.Event;

import java.util.List;

public class Repository {



    public static final List<Event> eventList = LoadJson.loadJsonAsArray("src/main/resources/events.json");;

    public static List<Event> favoritesList = LoadJson.loadJsonAsArray("src/main/resources/favorites.json");


    private Repository() {

    }

}
