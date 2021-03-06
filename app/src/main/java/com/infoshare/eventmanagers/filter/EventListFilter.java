package com.infoshare.eventmanagers.filter;

import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.repository.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class EventListFilter {

    /**
     * Method filters list of Events by date provided as parameter.
     * @param date LocalDate variable provided for list filtering needs.
     * @return list of filtered Events.
     */
    static List<Event> filterByDate(LocalDate date) {
        List<Event> filterEvent = Repository.eventList
                .stream()
                .filter(e -> e.getStartDateAsLocalDate().equals(date))
                .collect(Collectors.toList());
        return filterEvent;
    }

    /**
     * Method filters list of Events by a range of dates provided as parameters.
     * @param fromDate inclusive LocalDate variable defining beginning of a range provided for list filtering needs.
     * @param toDate inclusive LocalDate variable defining end of a range provided for list filtering needs.
     * @return list of filtered Events.
     */
    static List<Event> filterByDate(LocalDate fromDate, LocalDate toDate) {
        List<Event> filterEvent = Repository.eventList
                .stream()
                .filter(e -> e.getStartDateAsLocalDate().isAfter(fromDate.minusDays(1)))
                .filter(e -> e.getStartDateAsLocalDate().isBefore(toDate.plusDays(1)))
                .collect(Collectors.toList());
        return filterEvent;
    }

    /**
     * Method filters list of Events by String organizer provided as parameter.
     * @param organizer String variable provided for list filtering needs.
     * @return list of filtered Events.
     */
    static List<Event> filterByOrganizer(String organizer) {
        List<Event> filterEvent = Repository.eventList
                .stream()
                .filter(event -> event.getOrganizerAsString().equals(organizer))
                .collect(Collectors.toList());
        return filterEvent;
    }
}
