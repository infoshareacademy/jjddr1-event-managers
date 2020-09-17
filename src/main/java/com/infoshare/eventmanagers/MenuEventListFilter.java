package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuEventListFilter {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] menuList = {"Filtrowanie listy wydarzeń po dacie", "Filtrowanie listy wydarzeń po zakresie dat",
            "Filtrowanie listy wydarzeń po organizatorze"};

    /**
     * Method prints out user menu and calls other methods that implement specific functions.
     */
    public static void showMenu() {
        while (true) {
            printMenu();
            System.out.print("Dokonaj wyboru(0 by wyjść) :");
            int choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("Wybrano opcję: " + menuList[0]);
                    printFilterByDate();
                    break;
                case 2:
                    System.out.println("Wybrano opcję: " + menuList[1]);
                    printFilterByDates();
                    break;
                case 3:
                    System.out.println("Wybrano opcję: " + menuList[2]);
                    printFilterByOrganizer();
                    break;
                default:
                    System.out.println("Brak takiej opcji ");
            }
        }
    }

    /**
     * Method prints out menuList elements in graphically attractive way.
     */
    private static void printMenu() {
        printLine();
        for (int i = 0; i < menuList.length; i++) {
            System.out.println((i + 1) + ": " + menuList[i]);
        }
        printLine();
    }

    /**
     * Method prints out string of dashes.
     */
    static void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("─");
        }
        System.out.println();
    }


    /**
     * Method prints out list of events in user-friendly way.
     * @param eventList List of events to be printed out.
     */
    static void printEventList(List<Event> eventList) {
        for (Event event : eventList) {
            System.out.println(event);
        }
    }

    /**
     * Method handles scanning for user input that is used to call filterByDate method.
     * After executing the method, it's results are printed out to user.
     * In case no filtering results are returned, suitable message is printed out.
     */
    private static void printFilterByDate() {
        printLine();
        System.out.println("Podaj datę (rrrr-mm-dd): ");
        LocalDate date = null;
        try {
            date = LocalDate.parse(scanner.next());
        } catch (DateTimeParseException e) {
            System.out.println("Niewłaściwy format daty.");
            return;
        }
        printLine();
        List<Event> eventList = EventListFilter.filterByDate(date);
        if (eventList.isEmpty()) {
            System.out.println("Brak wydarzeń w podanym dniu.");
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
        System.out.println("Podaj początek zakresu dat (rrrr-mm-dd): ");
        LocalDate fromDate = null;
        try {
            fromDate = LocalDate.parse(scanner.next());
        } catch (DateTimeParseException e) {
            System.out.println("Niewłaściwy format daty.");
            return;
        }
        System.out.println("Podaj koniec zakresu dat (rrrr-mm-dd): ");
        LocalDate toDate = null;
        try {
            toDate = LocalDate.parse(scanner.next());
        } catch (DateTimeParseException e) {
            System.out.println("Niewłaściwy format daty.");
            return;
        }
        printLine();
        List<Event> eventList = EventListFilter.filterByDate(fromDate, toDate);
        if (eventList.isEmpty()) {
            System.out.println("Brak wydarzeń w podanym zakresie dat.");
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
        System.out.println("Podaj organizatora: ");
        scanner.nextLine();
        String organizer = scanner.nextLine();
        printLine();
        List<Event> eventList = EventListFilter.filterByOrganizer(organizer);
        if (eventList.isEmpty()) {
            System.out.println("Brak wydarzeń organizowanych przez tego organizatora.");
        } else {
            printEventList(eventList);
        }
    }

}

