package com.infoshare.eventmanagers;


import java.util.List;

public class Repository {


    public static final List<Event> eventList = LoadJson.loadJsonAsArray();





    private Repository() {

    }

}
