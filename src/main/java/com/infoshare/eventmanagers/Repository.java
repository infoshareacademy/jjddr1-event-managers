package com.infoshare.eventmanagers;


import com.infoshare.eventmanagers.Event;

import java.util.List;

public class Repository {

    public static final EventMgrProperties SETTINGS = new EventMgrProperties();
    public static final List<Event> eventList=new SaveJson().saveJsonAsArray();

    private Repository(){

    }

}
