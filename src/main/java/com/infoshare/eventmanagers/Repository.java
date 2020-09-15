package com.infoshare.eventmanagers;




import java.util.List;

public class Repository {

    public static final List<Event> eventList=new SaveJson().saveJsonAsArray();

    private Repository(){

    }

}
