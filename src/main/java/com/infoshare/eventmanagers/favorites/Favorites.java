package com.infoshare.eventmanagers.favorites;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.eventmanagers.Menu;
import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.repository.Repository;
import com.infoshare.eventmanagers.utils.Utils;
import jdk.jshell.execution.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    List<Event> favoritesList = Repository.favoritesList;

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

//        LOGGER.info("Write ID number of an event you want to add: \n");
        LOGGER.info("Podaj numer ID wydarzenia, które chcesz dodać: ");
        int index = Utils.makeAChoice();

        Optional<Event> eventList = Repository.eventList
                .stream()
                .filter(e -> e.getId() == index)
                .findFirst();

        if (eventList.isEmpty()) {
//            LOGGER.info("No such element in the list!\n");
            LOGGER.info("Nie ma takiego wydarzenia!\n");
        } else {
            favoritesList.add(eventList.get());
//            LOGGER.info("Event added to your List of Favourites.\n");
            LOGGER.info("Wydarzenie pomyślnie dodane do listy.\n");
        }
        saveToRepository();
    }

    /**
     * Searches an event by ID in favoritesList and deletes this event.
     */
    protected void deleteFromFavorites() {

        viewFavorites();
//        LOGGER.info("Write ID number of an event you want to delete: \n");
        LOGGER.info("Podaj numer ID wydarzenia, które chcesz dodać: ");
        int index = Utils.makeAChoice();

        List<Event> elementsToDelete = favoritesList
                .stream()
                .filter(e -> e.getId() == index)
                .collect(Collectors.toList());


        if (elementsToDelete.isEmpty()) {
//            LOGGER.info("No such element in the list!\n");
            LOGGER.info("Nie ma takiego wydarzenia!\n");
        } else {
            favoritesList.remove(elementsToDelete.get(0));
//            LOGGER.info("Event deleted form List of Favorites.\n");
            LOGGER.info("Wydarzenie pomyślnie usunięte z listy.\n");
        }
        saveToRepository();
    }

    /**
     * Prints every event in favoritesList
     */
    protected void viewFavorites() {
        Utils.printListByFive(Repository.favoritesList);
    }

    /**
     * Updates favoriteslist in Repository class.
     */
    public void saveToRepository() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get("src/main/resources/favorites.json").toFile(), favoritesList);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Repository.favoritesList = favoritesList;
    }


}