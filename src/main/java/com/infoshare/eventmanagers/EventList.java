package com.infoshare.eventmanagers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EventList {
    private final static Logger LOGGER = LogManager.getLogger(EventList.class);
    private final Scanner scanner = new Scanner(System.in);


    private void oneEventView(Event event) {

        int index;
        boolean nextLoop = true;
        index = Repository.eventList.indexOf(event);
        while (nextLoop) {
            clearScreen();
            Repository.eventList.get(index).printFull();
            if (index == 0) {
                LOGGER.info("\n1: Następne wydarzenie \n");
                LOGGER.info("2: Powrót do porzedniego menu \n");
                LOGGER.info("Wybierz opcję: ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                switch (choice) {
                    case 1:
                        index++;
                        break;
                    case 2:
                        nextLoop = false;
                        break;
                }
            } else if (index > 0 && index < Repository.eventList.size() - 1) {
                LOGGER.info("1: Następne wydarzenie \n");
                LOGGER.info("2: Poprzednie wydarzenie \n");
                LOGGER.info("3: Powrót do porzedniego menu \n");
                LOGGER.info("Wybierz opcję: ");
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
                LOGGER.info("1: Poprzednie wydarzenie \n");
                LOGGER.info("2: Powrót do porzedniego menu \n");
                LOGGER.info("Wybierz opcję: ");
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

    public void listView() {
        int start = 0;
        boolean next = true;
        while (next) {
            clearScreen();
            for (int i = start; i < start + 5; i++) {
                Repository.eventList.get(i).printAsList();
            }
            printLine();
            if (start == 0) {
                LOGGER.info("\n1: Następne 5 pozyji \n");
                LOGGER.info("2: Szczegóły pojedyńczego wydarzenia \n");
                LOGGER.info("3: Powrót do poprzedniego menu \n");
                LOGGER.info("Wybierz opcję: ");
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
                        LOGGER.info("Brak takiej opcji \n");
                }
            } else if (start > 0 && start < Repository.eventList.size() - 5) {
                LOGGER.info("\n1: Następne 5 pozyji \n");
                LOGGER.info("2: Poprzednie 5 pozyji \n");
                LOGGER.info("3: Szczegóły pojedyńczego wydarzenia \n");
                LOGGER.info("4: Powrót do poprzedniego menu \n");
                LOGGER.info("Wybierz opcję: ");

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
                        LOGGER.info("Brak takiej opcji \n");
                }
            } else {
                LOGGER.info("1: Poprzednie 5 pozyji \n");
                LOGGER.info("2: Szczegóły pojedyńczego wydarzenia \n");
                LOGGER.info("3: Powrót do poprzedniego menu \n");
                LOGGER.info("Wybierz opcję: ");
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
                        LOGGER.info("Brak takiej opcji \n");
                }
            }
        }
    }

    private void runOneEventView() {
        while (true) {
            LOGGER.info("\nProszę podać Id wydarzenia ( lub 0 by wrócić) : ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id == 0) {
                return;
            }
            List<Event> collect = Repository.eventList.parallelStream().filter(input -> input.getId() == id).collect(Collectors.toList());
            if (collect.isEmpty()) {
                LOGGER.info("Brak wydarzenia o podanym indeksie \n");
            } else {
                oneEventView(collect.get(0));
                break;
            }
        }
    }

    private void clearScreen() {

        LOGGER.info("\033[H\033[2J");
        LOGGER.info("\n");

    }

    private void printLine() {
        for (int i = 0; i < 84; i++) {
           LOGGER.info("─");
        }
    }
}
