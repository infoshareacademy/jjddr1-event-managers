package com.infoshare.eventmanagers.repository;


import com.infoshare.eventmanagers.model.Event;

import java.util.List;

public class Repository {



    public static final List<Event> eventList = LoadJson.loadJsonAsArray();;

    public static List<Event> favoritesList;



    private Repository() {

    }

}
