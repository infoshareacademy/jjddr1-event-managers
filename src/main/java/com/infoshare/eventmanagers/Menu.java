
package com.infoshare.eventmanagers;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private String[] menuList = {"Wyszukiwanie wydarzeń", "Lista wszystkich wydarzeń z widokiem pojedynczeho wydarzenia",
            "Filtrowanie listy wydarzeń", "Edycja konfiguracji", "Pokazywanie najbliższego w czasie ulubionego wydarzenia"};


    public void run() {
        System.out.println("Witaj w Event Manager");
        System.out.println("Have fun! :)");
        SaveJson saveJson = new SaveJson();
        Repository.eventList = saveJson.saveJsonAsArray();
        showMenu();

    }

    private void showMenu() {
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
                    break;
                case 2:
                    System.out.println("Wybrano opcję: " + menuList[1]);
                    break;
                case 3:
                    System.out.println("Wybrano opcję: " + menuList[2]);
                    break;
                case 4:
                    System.out.println("Wybrano opcję: " + menuList[3]);
                    break;
                case 5:
                    System.out.println("Wybrano opcję: " + menuList[4]);
                    break;
                default:
                    System.out.println("Brak takiej opcji ");
            }
        }
    }

    private void printMenu() {
        printLine();
        for (int i = 0; i < menuList.length; i++) {
            System.out.println((i + 1) + ": " + menuList[i]);
        }
        printLine();
    }

    void printLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("─");
        }
        System.out.println();
    }

}
