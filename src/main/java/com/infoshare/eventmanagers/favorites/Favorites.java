package com.infoshare.eventmanagers.favorites;

import com.infoshare.eventmanagers.Menu;
import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.repository.Repository;
import com.infoshare.eventmanagers.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Favorites {

    private final static Logger LOGGER = LogManager.getLogger(Menu.class);

    /**
     * Declaration of Scanner with console implementation.
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Declaration and initialization of List of Favorites Events.
     */
    List<Event> favoritesList = new ArrayList<>();

    /**
     * Prints Menu of Favorites Events.
     */
    protected static void printFavoriteMenu() {
        Utils.printLine();
        Utils.printMenu(MenuFavorites.menuListFavorites);
    }


    /**
     * Searches an event by ID in eventList and add this event to favoritesList.
     */
    protected void addToFavorites() {

        Utils.printListByFive(Repository.eventList);

        LOGGER.info("Write ID number of an event you want to add: \n");
        int index = Utils.makeAChoice();

        List<Event> eventList = Repository.eventList
                .stream()
                .filter(e -> e.getId() == index)
                .collect(Collectors.toList());

        if (eventList.isEmpty()) {
            LOGGER.info("No such element in the list!\n");
        } else {
            favoritesList.add(eventList.get(0));
            LOGGER.info("Event added to your List of Favourites.\n");
        }
        saveToRepository();
    }

    /**
     * Searches an event by ID in favoritesList and deletes this event.
     */
    protected void deleteFromFavorites() {

        viewFavorites();
        LOGGER.info("Write ID number of an event you want to delete: \n");
        int index = Utils.makeAChoice();

        List<Event> elementsToDelete = favoritesList
                .stream()
                .filter(e -> e.getId() == index)
                .collect(Collectors.toList());


        if (elementsToDelete.isEmpty()) {
            LOGGER.info("No such element in the list!\n");
        } else {
            favoritesList.remove(elementsToDelete.get(0));
            LOGGER.info("Event deleted form List of Favorites.\n");
        }
        saveToRepository();
    }

    /**
     * Prints every event in favoritesList
     */
    protected void viewFavorites() {
        Utils.printListByFive(favoritesList);
    }

    /**
     * Updates favoriteslist in Repository class.
     */
    public void saveToRepository() {
        Repository.favoritesList = favoritesList;
    }

}