package com.infoshare.eventmanagers;

import com.infoshare.eventmanagers.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.infoshare.eventmanagers.Event;
import com.infoshare.eventmanagers.SaveJson;

/**
 * A class to search the event from the whole list, by name.
 */
public class SearchingEvent {

    /**
     * A method that takes data from the user and compares it with data,
     * from a list of events.
     */
    public void run() {

        /**
         * Downloading data from the user.
         */
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę wydarzenia, które szukasz.");
        String givenEvent = scanner.nextLine();

        /**
         * Comparing the data entered by the user with the data from the event list.
         */
        boolean isFound = false;
        for (Event s : Repository.eventList) {
            if (s.getName().contains(givenEvent)) {
                isFound = true;
                System.out.println("Wydarzenie o które pytasz to : ");
                s.printMe();
                break;
            }
        }
        if (!isFound) {
            System.out.println("Przykro nam, nie ma takiego wydarzenia.");
        }
    }
}