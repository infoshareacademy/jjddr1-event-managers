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

public class LoadJson {
    private static final String PATHTOJSON = "src/main/java/resources/events.json";
    private static final Logger LOGGER = LogManager.getLogger(LoadJson.class);
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Path eventPaths = Paths.get(PATHTOJSON);
    private static String fileAsString;


    public static List<Event> loadJsonAsArray() {
        Event[] events = null;
        if (Files.exists(eventPaths)) {
            try {
                fileAsString = Files.readString(eventPaths);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                events = mapper.reader().forType(Event[].class).readValue(fileAsString);

            } catch (IOException e) {
                LOGGER.info("Ups! Coś poszło nie tak podczas otwierania pliku, lub odczytu, lub mapowania ");
            }

        }

        return Arrays.asList(events);
    }


}
