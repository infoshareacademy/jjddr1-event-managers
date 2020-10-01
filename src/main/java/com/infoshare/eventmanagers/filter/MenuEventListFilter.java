package com.infoshare.eventmanagers.filter;

import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.utils.Utils;
import jdk.jshell.execution.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuEventListFilter {
    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner scanner = new Scanner(System.in);

    private static final String[] MENU_LIST = {"Filtrowanie listy wydarzeń po dacie", "Filtrowanie listy wydarzeń po zakresie dat",
            "Filtrowanie listy wydarzeń po organizatorze"};
    public static final String MESSAGE = "Wybrano opcję: {}\n";

    /**
     * Method prints out user menu and calls other methods that implement specific functions.
     */
    public static void showMenu() {
        while (true) {
            Utils.printMenu(MENU_LIST);
            switch (Utils.makeAChoice()) {
                case 1:
                    STDOUT.info(MESSAGE, MENU_LIST[0]);
                    printFilterByDate();
                    break;
                case 2:
                    STDOUT.info(MESSAGE, MENU_LIST[1]);
                    printFilterByDates();
                    break;
                case 3:
                    STDOUT.info(MESSAGE, MENU_LIST[2]);
                    printFilterByOrganizer();
                    break;
                case 4:
                    return;
                default:
                    STDOUT.info("Brak takiej opcji\n");
            }
        }
    }

    /**
     * Method is responsible for calling methods responsible for gathering user input,
     * filtering and presenting its results to user.
     * In case user input is invalid, method aborts executing following methods.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByDate() {
        LocalDate date = Utils.makeADateChoice("Podaj datę (rrrr-mm-dd): ");
        if (date == null) return;
        List<Event> eventList = EventListFilter.filterByDate(date);
        if (eventList.isEmpty()) {
            Utils.printLine();
            STDOUT.info("Brak wydarzeń w podanym dniu.\n");
        } else {
            Utils.printListByFive(eventList);
        }
    }

    /**
     * Method is responsible for calling methods responsible for gathering user input,
     * filtering and presenting its results to user.
     * In case user input is invalid, method aborts executing following methods.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByDates() {
        LocalDate fromDate = Utils.makeADateChoice("Podaj początek zakresu dat (rrrr-mm-dd): ");
        if (fromDate == null) return;
        LocalDate toDate = Utils.makeADateChoice("Podaj koniec zakresu dat (rrrr-mm-dd): ");
        if (toDate == null) return;
        List<Event> eventList = EventListFilter.filterByDate(fromDate, toDate);
        if (eventList.isEmpty()) {
            Utils.printLine();
            STDOUT.info("Brak wydarzeń w podanym zakresie dat.\n");
        } else {
            Utils.printListByFive(eventList);
        }
    }

    /**
     * Method is responsible for gathering user input and calling methods responsible
     * for filtering and presenting its results to user.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByOrganizer() {
        Utils.printLine();
        STDOUT.info("Podaj organizatora: ");
        String organizer = scanner.nextLine();
        List<Event> eventList = EventListFilter.filterByOrganizer(organizer);
        if (eventList.isEmpty()) {
            Utils.printLine();
            STDOUT.info("Brak wydarzeń organizowanych przez tego organizatora.\n");
        } else {
            Utils.printListByFive(eventList);
        }
    }
}

