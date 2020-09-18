package com.infoshare.eventmanagers.filter;

import com.infoshare.eventmanagers.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuEventListFilter {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static Scanner scanner = new Scanner(System.in);

    private static String[] menuList = {"Filtrowanie listy wydarzeń po dacie", "Filtrowanie listy wydarzeń po zakresie dat",
            "Filtrowanie listy wydarzeń po organizatorze"};

    /**
     * Method prints out user menu and calls other methods that implement specific functions.
     */
    public static void showMenu() {
        while (true) {
            printMenu();
            STDOUT.info("Dokonaj wyboru(0 by wyjść) :");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                return;
            }
            switch (choice) {
                case 1:
                    STDOUT.info("Wybrano opcję: {}\n", menuList[0]);
                    printFilterByDate();
                    break;
                case 2:
                    STDOUT.info("Wybrano opcję: {}\n", menuList[1]);
                    printFilterByDates();
                    break;
                case 3:
                    STDOUT.info("Wybrano opcję: {}\n", menuList[2]);
                    printFilterByOrganizer();
                    break;
                default:
                    STDOUT.info("Brak takiej opcji\n");
            }
        }
    }

    /**
     * Method prints out menuList elements in graphically attractive way.
     */
    private static void printMenu() {
        printLine();
        for (int i = 0; i < menuList.length; i++) {
            STDOUT.info("{}: {}\n", (i + 1), menuList[i]);
        }
        printLine();
    }

    /**
     * Method prints out string of dashes.
     */
    static void printLine() {
        for (int i = 0; i < 80; i++) {
            STDOUT.info("─");
        }
        STDOUT.info("\n");
    }

    /**
     * Method prints out list of events in user-friendly way.
     *
     * @param eventList List of events to be printed out.
     */
    static void printEventList(List<Event> eventList) {
        for (Event event : eventList) {
            STDOUT.info("{}\n", event);
        }
    }

    /**
     * Method handles scanning for user input that is used to call filterByDate method.
     * After executing the method, it's results are printed out to user.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByDate() {
        printLine();
        STDOUT.info("Podaj datę (rrrr-mm-dd): ");
        LocalDate date = null;
        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            printLine();
            STDOUT.error("Niewłaściwy format daty.\n");
            return;
        }
        printLine();
        List<Event> eventList = EventListFilter.filterByDate(date);
        if (eventList.isEmpty()) {
            STDOUT.info("Brak wydarzeń w podanym dniu.\n");
        } else {
            printEventList(eventList);
        }
    }

    /**
     * Method handles scanning for user input that is used to call filterByDate method.
     * After executing the method, it's results are printed out to user.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByDates() {
        printLine();
        STDOUT.info("Podaj początek zakresu dat (rrrr-mm-dd): ");
        LocalDate fromDate = null;
        try {
            fromDate = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            printLine();
            STDOUT.info("Niewłaściwy format daty.\n");
            return;
        }
        STDOUT.info("Podaj koniec zakresu dat (rrrr-mm-dd): ");
        LocalDate toDate = null;
        try {
            toDate = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            printLine();
            STDOUT.error("Niewłaściwy format daty.\n");
            return;
        }
        printLine();
        List<Event> eventList = EventListFilter.filterByDate(fromDate, toDate);
        if (eventList.isEmpty()) {
            STDOUT.info("Brak wydarzeń w podanym zakresie dat.\n");
        } else {
            printEventList(eventList);
        }
    }

    /**
     * Method handles scanning for user input that is used to call filterByOrganizer method.
     * After executing the method, it's results are printed out to user.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByOrganizer() {
        printLine();
        STDOUT.info("Podaj organizatora: ");
        String organizer = scanner.nextLine();
        printLine();
        List<Event> eventList = EventListFilter.filterByOrganizer(organizer);
        if (eventList.isEmpty()) {
            STDOUT.info("Brak wydarzeń organizowanych przez tego organizatora.\n");
        } else {
            printEventList(eventList);
        }
    }
}

