package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventListFilter {

    private static SaveJson saveJson = new SaveJson();

    static List<Event> filterByDate(LocalDate date) {
        List<Event> filterEvent = saveJson.saveJsonAsArray()
                .stream()
                .filter(e -> e.getStartDate().equals(date))
                .collect(Collectors.toList());
        return filterEvent;
    }

    static List<Event> filterByDate(LocalDate fromDate, LocalDate toDate) {
        List<Event> filterEvent = saveJson.saveJsonAsArray()
                .stream()
                .filter(e -> e.getStartDate().isAfter(fromDate.minusDays(1)))
                .filter(e -> e.getStartDate().isBefore(toDate.plusDays(1)))
                .collect(Collectors.toList());
        return filterEvent;
    }

    static List<Event> filterByOrganizer(String organizer) {
        List<Event> filterEvent = saveJson.saveJsonAsArray()
                .stream()
                .filter(event -> event.getOrganizer().equals(organizer))
                .collect(Collectors.toList());
        return filterEvent;
    }
}
