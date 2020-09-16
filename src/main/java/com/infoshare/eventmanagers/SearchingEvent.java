package com.infoshare.eventmanagers;

import com.infoshare.eventmanagers.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.infoshare.eventmanagers.Event;
import com.infoshare.eventmanagers.SaveJson;

public class SearchingEvent {

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj nazwę wydarzenia, które szukasz");
        String givenEvent = scanner.nextLine();

        boolean isFound = false;
        for (Event s : Repository.eventList) {
            if (s.getName().contains(givenEvent)) {
                isFound = true;
                System.out.println("Wydarzenie o które pytasz to : ");
                s.printMe();
                break;
            }
        }
        if (!isFound) {
            System.out.println("Przykro nam, nie ma takiego wydarzenia.");
        }
    }
}