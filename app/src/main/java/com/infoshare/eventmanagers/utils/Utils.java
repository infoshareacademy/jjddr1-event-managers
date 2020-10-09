package com.infoshare.eventmanagers.utils;

import com.infoshare.eventmanagers.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Utils {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");
    private static final Scanner scanner = new Scanner(System.in);

    public static void printMenu(String[] menuArray) {

        printLine();
        int i = 0;
        for (; i < menuArray.length; i++) {
            STDOUT.info("{}: {}\n", (i + 1), menuArray[i]);
        }
        STDOUT.info("{}: Powrót \n", i + 1);
        printLine();
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


    public static void printListByFive(List<Event> eventList) {
        Printer.runListView(eventList);
    }

    /**
     * Method  for reading input from user, with try-catch block, if user doesn't pass  numbers then  return 0;
     *
     * @return a int @choice from scanner, if @parseInt throw a NumberFormatException  method return 0
     */


    public static int makeAChoice() {
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine().trim());

        } catch (NumberFormatException n) {
            choice = 0;
        }
        return choice;
    }

    /**
     * Method is responsible for gathering user input, used to initialize LocalDate variable,
     * that method returns. In case of LocalDate parsing failure, null value is returned and
     * suitable message is printed out.
     *
     * @param message String parameter containing suitable message presented to user before gathering input.
     * @return LocalDate variable containing user entered value.
     * In case of LocalDate parsing failure, null value is returned.
     */
    public static LocalDate makeADateChoice(String message) {
        printLine();
        STDOUT.info(message);
        LocalDate date = null;
        try {
            date = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException e) {
            printLine();
            STDOUT.error("Nieprawidłowy format daty.\n");
        }
        return date;
    }


}
