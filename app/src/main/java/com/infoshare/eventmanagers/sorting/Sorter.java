package com.infoshare.eventmanagers.sorting;

import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.properties.EventMgrProperties;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    EventMgrProperties properties;

    public Sorter() {
        this.properties = EventMgrProperties.getInstance();
    }

    public List<Event> sort(List<Event> list) {
        String sortingOrder = properties.getSortingOrder();
        boolean ascending = properties.checkIfAscending();
        switch (sortingOrder) {
            case "organizator": {
                return sortByOrganizer(list, ascending);
            }
            case "data": {
                return sortByDate(list, ascending);

            }
            case "nazwa": {
                return sortByName(list, ascending);
            }
            default:
                throw new IllegalStateException("Unexpected value: " + sortingOrder);
        }
    }

    private List<Event> sortByName(List<Event> list, boolean ascending) {
        Comparator<Event> compareByName = new CompareByName();
        List<Event> sortedList = list.stream().sorted(compareByName).collect(Collectors.toList());
        if (ascending) {
            return sortedList;
        } else {
            Collections.reverse(sortedList);
        }
        return sortedList;
    }

    private List<Event> sortByDate(List<Event> list, boolean ascending) {
        Comparator<Event> compareByDate = new CompareByDate();
        List<Event> sortedList = list.stream().sorted(compareByDate).collect(Collectors.toList());
        if (ascending) {
            return sortedList;
        } else {
            Collections.reverse(sortedList);
        }
        return sortedList;
    }

    private List<Event> sortByOrganizer(List<Event> list, boolean ascending) {
        Comparator<Event> compareByOrganizer = new CompareByOrganizer();
        List<Event> sortedList = list.stream().sorted(compareByOrganizer).collect(Collectors.toList());
        if (ascending) {
            return sortedList;
        } else {
            Collections.reverse(sortedList);
        }
        return sortedList;
    }
}
