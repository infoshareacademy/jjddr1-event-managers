package com.infoshare.eventmanagers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Menu {
    private final static Logger LOGGER = LogManager.getLogger(Menu.class);
    private final String[] MENULIST = {"Wyszukiwanie wydarzeń", "Lista wszystkich wydarzeń z widokiem pojedynczeho wydarzenia",
            "Filtrowanie listy wydarzeń", "Edycja konfiguracji", "Pokazywanie najbliższego w czasie ulubionego wydarzenia"};
    private Scanner scanner = new Scanner(System.in);


    public void run() {
        LOGGER.info("Witaj w Event Manager\n");
        LOGGER.info("Have fun! :)\n");
        showMenu();

    }

    private void showMenu() {
        boolean next = true;
        while (next) {
            clearScreen();
            printMenu();
            LOGGER.info("Dokonaj wyboru :");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            if (choice == 0) {
                return;
            }
            switch (choice) {
                case 1:
                    LOGGER.info("Wybrano opcję: {}\n ", MENULIST[0]);
                    break;
                case 2:
                    LOGGER.info("Wybrano opcję: {} \n", MENULIST[1]);
                    new EventList().listView();
                    break;
                case 3:
                    LOGGER.info("Wybrano opcję: {} \n", MENULIST[2]);
                    break;
                case 4:
                    LOGGER.info("Wybrano opcję: {} \n", MENULIST[3]);
                    MenuEventMgrProperties eventMenu = new MenuEventMgrProperties();
                    eventMenu.displayPropertiesMenu();
                    break;
                case 5:
                    LOGGER.info("Wybrano opcję: {} \n", MENULIST[4]);
                    break;
                case 6:
                    next = false;
                    break;
                default:
                    LOGGER.info("Brak takiej opcji \n");
            }
        }
    }

    private void printMenu() {
        printLine();
        for (int i = 0; i < MENULIST.length; i++) {
            LOGGER.info("{}: {}\n", (i + 1), MENULIST[i]);
        }
        LOGGER.info("6: Wyjście \n");
        printLine();
    }

    void printLine() {
        for (int i = 0; i < 80; i++) {
            LOGGER.info("─");
        }
        LOGGER.info("\n");
    }

    public void clearScreen() {

        LOGGER.info("\033[H\033[2J");
        LOGGER.info("\n");

    }

}
