package com.infoshare.eventmanagers;


import com.infoshare.eventmanagers.Event;

import java.util.List;

public class Repository {

    public static  List<Event> eventList= new SaveJson().saveJsonAsArray() ;

    private Repository(){

    }

}
