package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class to display the incoming event from the favorites list.
 */
public class IncomingEvent {

    /**
     * Downloads a list of favorite events, checks that the list is not less than zero.
     * Uploads to stream, filters by start date of event, compared to the current date,
     * than put it back to the list, and print the first incoming event details.
     */
    void run() {

        if (Repository.eventList.size() > 0) {

            List<Event> dates = Repository.eventList
                    .stream()
                    .filter(e -> e.getStartDate().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());

            System.out.println(dates.get(0));

        } else {
            System.out.println("Nie posiadasz żadnych wydarzeń, dodanych do ulubionych.");
        }
    }
}
