package com.infoshare.eventmanagers.favorites;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A class to display the incoming event from the favorites list.
 */
public class IncomingEvent {
    private static final Logger LOGGER = LogManager.getLogger(IncomingEvent.class);

    private static List<Event> favoritesList = Favorites.favoriteList();

    /**
     * Downloads a list of favorite events, checks that the list is not less than zero.
     * Uploads to stream, filters by start date of event, compared to the current date,
     * than put it back to the list, and print the first incoming event details.
     */
    public static void run() {

        if (favoritesList.size() > 0) {

            List<Event> dates = favoritesList
                    .stream()
                    .filter(e -> e.getStartDate().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());

            LOGGER.info(dates.get(0));

        } else {
            LOGGER.info("Nie posiadasz żadnych wydarzeń, dodanych do ulubionych.");
        }
    }
}
