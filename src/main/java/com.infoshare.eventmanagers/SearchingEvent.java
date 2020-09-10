package main.java.com.infoshare.eventmanagers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchingEvent {

    public SearchingEvent() {
    }

    public static void main(String[] args) {

        //przykładowa lista

        List<String> listOfEvents = new ArrayList(Arrays.asList("Koncert1", "Koncert2", "coś tam coś"));
        Scanner scanner = new Scanner(System.in);

        //pobierz dane od użytkownika

        System.out.println("Podaj nazwę wydarzenia, które szukasz");
        String givenEvent = scanner.nextLine();

        boolean isFound = false;
        for (String s : listOfEvents) {
            if (s.equals(givenEvent)) {
                isFound = true;
                System.out.println("Wydarzenie o które pytasz to : " + s);
                break;
            }
        }
        if (!isFound) {
            System.out.println("Przykro nam, nie ma takiego wydarzenia.");
        }
    }
}