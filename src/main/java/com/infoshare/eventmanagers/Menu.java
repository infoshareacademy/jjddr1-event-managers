package com.infoshare.eventmanagers;

import com.infoshare.eventmanagers.favorites.Favorites;
import com.infoshare.eventmanagers.favorites.IncomingEvent;
import com.infoshare.eventmanagers.filter.MenuEventListFilter;
import com.infoshare.eventmanagers.properties.MenuEventMgrProperties;
import com.infoshare.eventmanagers.repository.Repository;
import com.infoshare.eventmanagers.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Menu {

    private final static Logger LOGGER = LogManager.getLogger(Menu.class);
    private final String message = "Wybrano opcję: {} \n";

    private final String[] MENU_LIST = {"Wyszukiwanie wydarzeń", "Lista wszystkich wydarzeń z widokiem pojedyńczego wydarzenia",
            "Filtrowanie listy wydarzeń", "Edycja konfiguracji", "Pokazywanie najbliższego w czasie ulubionego wydarzenia",
            "Dodawanie/usuwanie ulubionych wydarzeń"};


    public void run() {
        LOGGER.info("Witaj w Event Manager\n");
        LOGGER.info("Have fun! :)\n");
        showMenu();

    }

    private void showMenu() {
        boolean next = true;
        while (next) {
            Utils.clearScreen();
            Utils.printMenu(MENU_LIST);
            switch (Utils.makeAChoice()) {
                case 1:
                    LOGGER.info(message, MENU_LIST[0]);
                    SearchingEvent newSerchingEvent = new SearchingEvent();
                    newSerchingEvent.run();
                    break;
                case 2:
                    LOGGER.info(message, MENU_LIST[1]);
                    Utils.printListByFive(Repository.eventList);
                    break;
                case 3:
                    LOGGER.info(message, MENU_LIST[2]);
                    MenuEventListFilter.showMenu();
                    break;
                case 4:
                    LOGGER.info(message, MENU_LIST[3]);
                    MenuEventMgrProperties eventMenu = new MenuEventMgrProperties();
                    eventMenu.displayPropertiesMenu();
                    break;
                case 5:
                    LOGGER.info(message, MENU_LIST[4]);
                    IncomingEvent.run();
                    break;
                case 6:
                    LOGGER.info(message, MENU_LIST[5]);
                    Favorites favorites = new Favorites();
                    favorites.showFavoriteMenu();
                    break;
                case 7:
                    next = false;
                    break;
                default:
                    LOGGER.info("Brak takiej opcji \n");
            }
        }
    }

}
