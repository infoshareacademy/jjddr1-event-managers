package com.infoshare.eventmanagers.sorting;

import com.infoshare.eventmanagers.model.Event;

import java.util.Comparator;

public class CompareByOrganizer implements Comparator<Event> {

    @Override
    public int compare(Event e1, Event e2) {
        return e1.getOrganizerAsString().compareTo(e2.getOrganizerAsString());
    }
}
