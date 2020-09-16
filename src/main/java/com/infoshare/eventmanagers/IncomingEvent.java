package com.infoshare.eventmanagers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class IncomingEvent {

    void run() {

        if (Repository.eventList.size()>0) {

            List<LocalDate> dates = Repository.eventList.stream().map(e -> e.getStartDate()).sorted().filter(e -> e.isAfter(LocalDate.now())).collect(Collectors.toList());
            System.out.println(dates.get(0));

        } else {
                System.out.println("Nie masz żadnych wydarzeń dodanych do ulubionych." );
            }
    }
}
