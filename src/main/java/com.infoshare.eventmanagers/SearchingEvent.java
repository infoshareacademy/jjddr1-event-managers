package main.java.com.infoshare.eventmanagers;

import java.util.Scanner;

public class SearchingEvent {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //pobierz dane od użytkownika
        System.out.println("Podaj nazwę wydarzenia");
        String givenEvent = scanner.nextLine();
        System.out.println("Szukane wydarzenie to : " + givenEvent);

    }
}


