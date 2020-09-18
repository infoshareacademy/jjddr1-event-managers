package com.infoshare.eventmanagers;


import com.infoshare.eventmanagers.Event;

import java.util.List;

public class Repository {



    public static final List<Event> eventList = LoadJson.loadJsonAsArray();;




    private Repository() {

    }

}
