package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuEventListFilter {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] menuList = {"Filtrowanie listy wydarzeń po dacie", "Filtrowanie listy wydarzeń po zakresie dat",
            "Filtrowanie listy wydarzeń po organizatorze"};

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

    private static void printMenu() {
        printLine();
        for (int i = 0; i < menuList.length; i++) {
            System.out.println((i + 1) + ": " + menuList[i]);
        }
        printLine();
    }

    static void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("─");
        }
        System.out.println();
    }

    static void printEventList(List<Event> eventList) {
        for (Event event : eventList) {
            System.out.println(event);
        }
    }

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

