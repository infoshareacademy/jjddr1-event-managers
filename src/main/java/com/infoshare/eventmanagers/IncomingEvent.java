package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A class to display the incoming event from the favorites list.
 */
public class IncomingEvent {
    private static final Logger LOGGER = LogManager.getLogger(EventMgrProperties.class);

    /**
     * Downloads a list of favorite events, checks that the list is not less than zero.
     * Uploads to stream, filters by start date of event, compared to the current date,
     * than put it back to the list, and print the first incoming event details.
     */
    void run() {

        if (Repository.favoritesList.size() > 0) {

            List<Event> dates = Repository.favoritesList
                    .stream()
                    .filter(e -> e.getStartDate().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());

            LOGGER.info(dates.get(0));

        } else {
            LOGGER.info("Nie posiadasz żadnych wydarzeń, dodanych do ulubionych.");
        }
    }
}
