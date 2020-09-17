package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class IncomingEvent {

    void run() {

        if (Repository.eventList.size()>0) {

            List<Event> dates = Repository.eventList
                    .stream()
                    .filter(e -> e.getStartDate().isAfter(LocalDate.now()))
                    .collect(Collectors.toList());

            System.out.println(dates.get(0));

        } else {
                System.out.println("Nie masz żadnych wydarzeń dodanych do ulubionych." );
            }
    }
}
