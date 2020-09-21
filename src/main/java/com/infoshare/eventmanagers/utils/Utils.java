package com.infoshare.eventmanagers.utils;

import com.infoshare.eventmanagers.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Utils {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void printMenu(String[] menuArray) {

        int i = 0;
        for (; i < menuArray.length; i++) {
            STDOUT.info("{}: {}\n", (i + 1), menuArray[i]);
        }
        STDOUT.info("{}: Powrót \n", i + 1);
        STDOUT.info("Wybierz opcję: ");

    }

    public static void printLine() {
        for (int i = 0; i < 84; i++) {
            STDOUT.info("─");
        }
        STDOUT.info("\n");
    }

    public static void clearScreen() {
        STDOUT.info("\033[H\033[2J");
        STDOUT.info("\n");
    }

    // TODO:implement methods in Printer class, then call them in static context here.
    public static void printListByFive(List<Event> eventList) {
        Printer.runListView(eventList);
    }

}
