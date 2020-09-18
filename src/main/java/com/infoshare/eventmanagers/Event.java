package com.infoshare.eventmanagers;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;

public class Event {
    private static final Logger LOGGER = LogManager.getLogger(Event.class);


    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    private String placeName;
    private String organizer;
    private LocalDate startDate;

    private String descShort;

    public Event() {
    }

    @JsonProperty("descShort")
    public void setDescShort(String descShort) {
        descShort = descShort.replaceAll("\\s{2,}", " ").trim();
        descShort = descShort.replaceAll("/\n/g, ", "");

        this.descShort = descShort;
    }

    @JsonProperty("place")
    public void setPlaceName(Place place) {
        this.placeName = place.getName();
    }

    @JsonProperty("organizer")
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer.getDesignation();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate.substring(0, 10));
    }

    public void printFull() {
        for (int i = 0; i < 84; i++) {
            System.out.print("─");
        }
        ;
        LOGGER.info("\n| Id: {}", id);
        printName(name);
        LOGGER.info("\n| Miejsce: {}", placeName);
        LOGGER.info("\n| Organizator: {}", organizer);
        LOGGER.info("\n| Data rozpoczęcia: {}", startDate);
        printShortDesc(descShort);
        LOGGER.info("\n");
        for (int i = 0; i < 84; i++) {
            LOGGER.info("─");
        }
        LOGGER.info("\n");
    }


    private void printName(String name) {
        if ((name.length() > 73)) {

            LOGGER.info("\n| Nazwa: {}", name.substring(0, 73));
            LOGGER.info("\n| {}", name.substring(73));
        } else {
            LOGGER.info("\n| Nazwa: {}", name);
        }
    }


    public void printAsList() {
        for (int i = 0; i < 84; i++) {
            LOGGER.info("─");
        }

        LOGGER.info("\n| Id : {} | Miejsce: {} \n| {} | Nazwa: {} \n", id, placeName, startDate, ((name.length() > 58) ? name.substring(0, 62) : name));
    }

    private void printShortDesc(String descShort) {
        if (descShort == null) {
            return;
        }

        if (descShort.length() < 69) {
            LOGGER.info("\n| Krótki opis: {}", descShort);
            return;
        }
        LOGGER.info("\n| Krótki opis: {}", descShort.substring(0, 69));
        String descShortSubstring = descShort.substring(69);
        while (descShortSubstring.length() > 78) {
            LOGGER.info("\n| {}", descShortSubstring.substring(0, 78));
            descShortSubstring = descShortSubstring.substring(78);
        }
        LOGGER.info("\n| {}", descShortSubstring);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, placeName, organizer, startDate, descShort);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(name, event.name) &&
                Objects.equals(placeName, event.placeName) &&
                Objects.equals(organizer, event.organizer) &&
                Objects.equals(startDate, event.startDate) &&
                Objects.equals(descShort, event.descShort);
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", placeName='" + placeName + '\'' +
                ", organizer='" + organizer + '\'' +
                ", startDate='" + startDate + '\'' +
                ", descShort='" + descShort + '\'' +
                '}';
    }

    class Place {

        @JsonProperty("name")
        String name;

        public Place() {

        }

        public String getName() {
            return name;
        }
    }

    class Organizer {
        String designation;

        public Organizer() {
        }

        public String getDesignation() {
            return designation;
        }
    }

}
