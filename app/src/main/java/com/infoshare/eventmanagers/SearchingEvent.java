package com.infoshare.eventmanagers;

import java.util.Scanner;

import com.infoshare.eventmanagers.properties.EventMgrProperties;
import com.infoshare.eventmanagers.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.infoshare.eventmanagers.model.Event;

/**
 * A class to search the event from the whole list, by name.
 */
public class SearchingEvent {
    private static final Logger LOGGER = LogManager.getLogger(EventMgrProperties.class);

    /**
     * A method that takes data from the user and compares it with data,
     * from a list of events.
     */
    public void run() {

        /**
         * Downloading data from the user.
         */
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Podaj nazwę wydarzenia, które szukasz : ");
        String givenEvent = scanner.nextLine();

        /**
         * Comparing the data entered by the user with the data from the event list.
         */
        boolean isFound = false;
        for (Event s : Repository.eventList) {
            if (s.getName().contains(givenEvent)) {
                isFound = true;
                LOGGER.info("Wydarzenie o które pytasz to : \n");
                s.printFull();
                break;
            }
        }
        if (!isFound) {
            LOGGER.info("\nPrzykro nam, nie ma takiego wydarzenia.\n");
        }
    }
}