package com.infoshare.eventmanagers.LoadJson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadJson {

    private static final ObjectMapper mapper = new ObjectMapper();
    private final Path eventPaths = Paths.get("src/main/java/resources/events.json");
    private String fileAsString;

    public void run() {
        System.out.println(eventPaths);
        if (Files.exists(eventPaths)) {
            try {
                fileAsString = Files.readString(eventPaths);
                System.out.println(fileAsString);
                Event[] events = mapper.readValue(fileAsString, Event[].class);
//                System.out.println(fileAsString);
//                    for (Event e : events) {
//                        System.out.println(e.toString());
//                    }
                }catch (JsonParseException J) {
                System.out.println("JsonParseException if underlying input contains invalid content\n" +
                        "     *    of type {@link JsonParser} supports (JSON for default case)");
                }catch (JsonMappingException J){
                System.out.println(" @throws JsonMappingException if the input JSON structure does not match structure\n" +
                        "     *   expected for result type (or has other mismatch issues)");

                } catch (IOException e) {
                    System.out.println("Ups! Coś poszło nie tak podczas otwierania pliku ");
                }

        }


    }


}
