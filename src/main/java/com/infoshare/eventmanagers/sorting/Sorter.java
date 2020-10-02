package com.infoshare.eventmanagers.sorting;

import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.properties.EventMgrProperties;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    EventMgrProperties properties;

    public Sorter(EventMgrProperties properties) {
        this.properties = properties;
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
        return list.stream().sorted(compareByName).collect(Collectors.toList());
    }

    private List<Event> sortByDate(List<Event> list, boolean ascending) {
        Comparator<Event> compareByDate = new CompareByDate();
        return list.stream().sorted(compareByDate).collect(Collectors.toList());
    }

    private List<Event> sortByOrganizer(List<Event> list, boolean ascending) {
        Comparator<Event> compareByOrganizer = new CompareByOrganizer();
        return list.stream().sorted(compareByOrganizer).collect(Collectors.toList());
    }
}
