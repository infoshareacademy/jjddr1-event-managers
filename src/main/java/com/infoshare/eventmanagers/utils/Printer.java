package com.infoshare.eventmanagers.utils;

import com.infoshare.eventmanagers.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.infoshare.eventmanagers.utils.Utils.*;

public class Printer {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private final List<Event> eventList;
    private Scanner scanner = new Scanner(System.in);

    public Printer(List<Event> eventList) {
        this.eventList = eventList;
    }

    public void listView() {
        int start = 0;
        boolean next = true;
        while (next) {
            clearScreen();
            if ((start + 5) < eventList.size()) {
                for (int i = start; i < start + 5; i++) {
                    eventList.get(i).printAsList();
                }
            } else {
                for (int i = start; i < eventList.size(); i++) {
                    eventList.get(i).printAsList();
                }
            }
            printLine();
            if (start == 0) {
                printMenu(new String[]{"Następne 5 pozycji", "Szczegóły pojedyńczego wydarzenia"});
                switch (Integer.parseInt(scanner.nextLine().trim())) {
                    case 1:
                        start += 5;
                        break;
                    case 2:
                        runOneEventView();
                        break;
                    case 3:
                        next = false;
                        break;
                    default:
                        STDOUT.info("Brak takiej opcji \n");
                }
            } else if (start > 0 && start < eventList.size() - 5) {
                printMenu(new String[]{"Następne 5 pozycji", "Poprzednie 5 pozycji", "Szczególy pojedyńczego wydarzenia"});
                switch (Integer.parseInt(scanner.nextLine().trim())) {
                    case 1:
                        start += 5;
                        break;
                    case 2:
                        start -= 5;
                        break;
                    case 3:
                        runOneEventView();
                        break;
                    case 4:
                        next = false;
                        break;
                    default:
                        STDOUT.info("Brak takiej opcji \n");
                }
            } else {
                printMenu(new String[]{"Poprzednie 5 pozyji", "Szczegóły pojedyńczego wydarzenia"});
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        start -= 5;
                        break;
                    case 2:
                        runOneEventView();
                        break;
                    case 3:
                        next = false;
                        break;
                    default:
                        STDOUT.info("Brak takiej opcji \n");
                }
            }
        }
    }


    public void runOneEventView() {
        while (true) {
            STDOUT.info("\nProszę podać Id wydarzenia ( lub 0 by wrócić) : ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id == 0) {
                return;
            }
            List<Event> collect = eventList.parallelStream().filter(input -> input.getId() == id).collect(Collectors.toList());
            if (collect.isEmpty()) {
                STDOUT.info("Brak wydarzenia o podanym indeksie \n");
            } else {
                oneEventView(collect.get(0));
                break;
            }
        }
    }

    private void oneEventView(Event event) {

        int index;
        boolean nextLoop = true;
        index = eventList.indexOf(event);
        while (nextLoop) {
            clearScreen();
            eventList.get(index).printFull();
            if (index == 0) {
                printMenu(new String[]{"Następne wydarzenie"});
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        index++;
                        break;
                    case 2:
                        nextLoop = false;
                        break;
                }
            } else if (index > 0 && index < eventList.size() - 1) {
                printMenu(new String[]{"Następne wydarzenie", "Poprzednie wydarzenie"});
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        index++;
                        break;
                    case 2:
                        index--;
                        break;
                    case 3:
                        nextLoop = false;
                        break;
                }
            } else {
                printMenu(new String[]{"Poprzednie wydarzenie"});
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        index--;
                        break;
                    case 2:
                        nextLoop = false;
                        break;
                }
            }
        }
    }
}
