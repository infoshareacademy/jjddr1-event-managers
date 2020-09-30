package com.infoshare.eventmanagers.properties;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.infoshare.eventmanagers.Main.SETTINGS;

public class MenuEventMgrProperties {

    private static final Logger LOGGER = LogManager.getLogger(MenuEventMgrProperties.class);
    private static final String MENU_LINE = getLine();
    private static final Scanner SCANNER = new Scanner(System.in);

    public MenuEventMgrProperties() {
    }

    private static String getLine() {
        return ("─".repeat(80) + "\n");
    }

    public void displayPropertiesMenu() {
        while (true) {
            LOGGER.info("\n########## Ustawienia ##########\n");
            LOGGER.info("Obecnie ustawienia:\n");
            LOGGER.info(SETTINGS.toString());
            LOGGER.info("1: Zmień tryb sortowania\n" +
                    "2: Zmień format daty\n" +
                    "3: Przywróć ustawienia domyślne\n" +
                    "4: Zapisz ustawienia\n" +
                    "Naciśnij [ENTER] aby wrócić do głównego menu\n");
            LOGGER.info(MENU_LINE);
            LOGGER.info("Wybierz opcję:");
            String userInput = SCANNER.nextLine();
            if (userInput.equals("")) return;
            else
                try {
                    int input = Integer.parseInt(userInput);
                    switch (input) {
                        case 1:
                            displaySortingOrderMenu();
                            break;
                        case 2:
                            displayDateFormatMenu();
                            break;
                        case 3: {
                            SETTINGS.resetProperties();
                            LOGGER.info("Przywrócono ustawienia domyślne.\n");
                            break;

                        }
                        case 4: {
                            SETTINGS.saveProperties();
                            LOGGER.info("Ustawienia zapisane.\n");
                            break;
                        }
                        default: {
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    LOGGER.warn("Nie rozumiem. Wybierz opcję z listy.\n");
                }
        }
    }

    /**
     * Displays menu to change the sorting order
     */
    private void displaySortingOrderMenu() {
        while (true) {
            LOGGER.info("Wybierz porządek sortowania\n");
            LOGGER.info("Obecnie sortuję po: " + SETTINGS.getSortingOrder() + ", " +
                    getSortingDirectionAsString() + ".\n");
            LOGGER.info(MENU_LINE);
            LOGGER.info("Wybierz opcję: \n" +
                    "1: Sortuj po organizatorze\n" +
                    "2: Sortuj po dacie\n" +
                    "3. Sortuj po nazwie wydarzenia\n" +
                    "4. Zmień rosnąco/malejąco.\n" +
                    "Naciśnij [ENTER] aby wrócić do głównego menu\n");
            LOGGER.info("Wybierz opcję:\n");
            String userInput = SCANNER.nextLine();
            if (userInput.equals("")) return;
            else {
                try {
                    int input = Integer.parseInt(userInput);
                    switch (input) {
                        case 1: {
                            SETTINGS.setSortingOrder(
                                    SortingOrder.ORGANIZATOR.toString());
                            break;
                        }
                        case 2: {
                            SETTINGS.setSortingOrder(
                                    SortingOrder.DATA.toString());
                            break;
                        }
                        case 3: {
                            SETTINGS.setSortingOrder(SortingOrder.NAZWA.toString());
                            break;
                        }
                        case 4: {
                            SETTINGS.switchSortingDirection();
                            break;
                        }
                        default: {
                            return;
                        }
                    }
                } catch (NumberFormatException e) {
                    LOGGER.warn("Nie rozumiem. Wybierz opcję z listy\n");
                }
            }
        }
    }

    /**
     * Display window to change the date format
     */
    private void displayDateFormatMenu() {
        while (true) {
            LOGGER.info("Zmień format daty\n");
            LOGGER.info("Obecny format to: " + SETTINGS.getDateFormatAsString() + "\n");
            LOGGER.info(MENU_LINE);
            LOGGER.info("Podaj nowy format daty lub " +
                    "naciśnij enter aby wrócić do poprzedniego menu.\n");
            SCANNER.reset();
            String userInput = SCANNER.nextLine();
            if (userInput.equals("")) {
                return;
            } else {
                boolean dateFormatCorrect = SETTINGS.setDateFormat(userInput);
                if (!dateFormatCorrect) {
                    LOGGER.error("Niepoprawny format daty.");
                }
            }
        }
    }

    private String getSortingDirectionAsString() {
        if (SETTINGS.getSortingDirection().equals("true")) {
            return "rosnąco";

        } else if (SETTINGS.getSortingDirection().equals("false")) {
            return "malejąco";
        }
        return null;
    }
}

