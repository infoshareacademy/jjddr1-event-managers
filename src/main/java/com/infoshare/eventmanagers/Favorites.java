package com.infoshare.eventmanagers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Favorites {
    List<Event> favoritesList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    String[] menuListFavorites = {"Wyświetl listę ulubionych wydarzeń", "Dodaj wydarzenie do listy ulubionych",
            "Usuń wydarzenie z listy ulubionych"};


    public void showFavoriteMenu() {
        System.out.println("WITAMY W MENU ULUBIONYCH!!!");
        printFavoriteMenu();
        System.out.println("Wybierz opcję wpisując numer i zatwierdzając klawiszem 'enter'.");
        System.out.println("Aby wyjść z menu wydarzeń ulubionych wciśnij '0' i zatwierdź.");
        while (true) {
            int choice = scanner.nextInt();
            if (choice == 0) {
                return;
            }
            switch (choice) {
                case 1:
                    System.out.println("Wybrano opcję: " + menuListFavorites[0]);
                    viewFavorites();
                    break;
                case 2:
                    System.out.println("Wybrano opcję: " + menuListFavorites[1]);
                    addToFavorites(int id);
                    break;
                case 3:
                    System.out.println("Wybrano opcję: " + menuListFavorites[2]);
                    break;
                default:
                    System.out.println("Brak takiej opcji ");
            }
        }
    }

    private void printFavoriteMenu() {
        Menu menu = new Menu();
        menu.printLine();
        for (int i = 0; i < menuListFavorites.length; i++) {
            System.out.println((i + 1) + ": " + menuListFavorites[i]);
        }
        menu.printLine();
    }

    void addToFavorites(int id) {
        favoritesList.add(Repository.eventList);
    }

    void deleteFromFavorites(Event event) {
        favoritesList.remove(event);
    }

    void viewFavorites() {
        for (Event event : favoritesList) {
            event.printMe();
        }
    }

}
