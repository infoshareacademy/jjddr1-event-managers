package com.infoshare.eventmanagers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class SaveJson {
    private static final Logger LOGGER = LogManager.getLogger(Event.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Path eventPaths = Paths.get("/home/sebastian/Desktop/kurs/Projekt/jjddr1-event-managers/src/main/java/resources/events.json");
    private static String fileAsString;


    static public List<Event> saveJsonAsArray() {
        Event[] events = null;
        if (Files.exists(eventPaths)) {
            try {
                fileAsString = Files.readString(eventPaths);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                events = mapper.reader().forType(Event[].class).readValue(fileAsString);
                if (events == null) {
                    System.out.println(events);
                }

            } catch (IOException e) {
                LOGGER.info("Ups! Coś poszło nie tak podczas otwierania pliku, lub odczytu, lub mapowania ");
            }

        }

        return Arrays.asList(events);
    }


}
