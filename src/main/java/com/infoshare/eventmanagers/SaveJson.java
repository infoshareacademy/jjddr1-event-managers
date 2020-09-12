package com.infoshare.eventmanagers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.eventmanagers.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SaveJson {

    private final ObjectMapper mapper = new ObjectMapper();
    private final Path eventPaths = Paths.get("src/main/java/resources/events.json");
    private String fileAsString;


    public List<Event> saveJsonAsArray() {
        Event[] events = null;
        if (Files.exists(eventPaths)) {
            try {
                fileAsString = Files.readString(eventPaths);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                events = mapper.reader().forType(Event[].class).readValue(fileAsString);

            } catch (IOException e) {
                System.out.println("Ups! Coś poszło nie tak podczas otwierania pliku, lub odczytu, lub mapowania ");
            }

        }

        return Arrays.asList(events);
    }


}
