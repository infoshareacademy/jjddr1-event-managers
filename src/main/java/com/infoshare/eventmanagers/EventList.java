package com.infoshare.eventmanagers;

import java.util.Scanner;

public class EventList {
    private Scanner scanner = new Scanner(System.in);

    public void run() {

        boolean nextLoop = true;
        int choice;
        while (nextLoop) {
            System.out.println("1: Widok listy ");
            System.out.println("2: Widok pojedyńczego wydarzenia");
            System.out.print("Wybierz opcję: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    listView();
                    break;
                case 2:
                    oneEventView();
                    break;
                case 3:
                    nextLoop = false;
                    break;
            }
        }


    }

    private void oneEventView() {
        int i = 0;
        boolean nextLoop = true;
        while (nextLoop) {
            Repository.eventList.get(i).printFull();
            if (i == 0) {
                System.out.println("1: Następne wydarzenie");
                ;
                System.out.println("2: Powrót do porzedniego menu ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        i++;
                        break;
                    case 2:
                        nextLoop = false;
                        break;

                }

            } else if (i > 0 && i < Repository.eventList.size() - 1) {
                System.out.println("1: Następne wydarzenie");
                System.out.println("2: Poprzednie wydarzenie");
                System.out.println("3: Powrót do porzedniego menu ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        i++;
                        break;
                    case 2:
                        i--;
                        break;
                    case 3:
                        nextLoop = false;
                        break;
                }
            } else {
                System.out.println("1: Poprzednie wydarzenie");
                System.out.println("2: Powrót do porzedniego menu ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        i--;
                        break;
                    case 2:
                        nextLoop = false;
                        break;

                }

            }

        }
    }

    private void listView() {


    }
}
