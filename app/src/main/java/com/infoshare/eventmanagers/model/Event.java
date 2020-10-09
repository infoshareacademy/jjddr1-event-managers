package com.infoshare.eventmanagers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.infoshare.eventmanagers.properties.EventMgrProperties;
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
    private String place;
    private String organizer;
    private LocalDate startDate;

    private String descShort;


    public Event() {
    }

    public String getName() {
        return name;
    }

    public Place getPlace() {
        return new Place(place);
    }

    public void setPlace(Place place) {
        this.place = place.getName();
    }

    public String getDescShort() {
        return descShort;
    }

    @JsonProperty("descShort")
    public void setDescShort(String descShort) {
        descShort = descShort.replaceAll("\\s{2,}", " ").trim();
        descShort = descShort.replaceAll("/\n/g, ", "");

        this.descShort = descShort;
    }

    public int getId() {
        return id;
    }

    @JsonIgnore
    public LocalDate getStartDateAsLocalDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate.toString();
    }

    public void setStartDate(String startDate) {
        this.startDate = LocalDate.parse(startDate.substring(0, 10));
    }

    @JsonProperty("organizer")
    public Organizer getOrganizer() {
        return new Organizer(organizer);
    }


    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer.getDesignation();
    }


    @JsonIgnore
    public String getOrganizerAsString() {
        return organizer;
    }

    public void printFull() {
        for (int i = 0; i < 84; i++) {
            System.out.print("─");
        }
        LOGGER.info("\n| Id: {}", id);
        printName(name);
        LOGGER.info("\n| Miejsce: {}", place);
        LOGGER.info("\n| Organizator: {}", organizer);
        LOGGER.info("\n| Data rozpoczęcia: {}", this::getDateAsFormattedString);
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


    public void printAsElement() {
        for (int i = 0; i < 84; i++) {
            LOGGER.info("─");
        }

        LOGGER.info("\n| Id : {} | Miejsce: {} \n| {} | Nazwa: {} \n", id, place, getDateAsFormattedString(), ((name.length() > 62) ? name.substring(0, 62) : name));
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
        return Objects.hash(id, name, place, organizer, startDate, descShort);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return id == event.id &&
                Objects.equals(name, event.name) &&
                Objects.equals(place, event.place) &&
                Objects.equals(organizer, event.organizer) &&
                Objects.equals(startDate, event.startDate) &&
                Objects.equals(descShort, event.descShort);
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", placeName='" + place + '\'' +
                ", organizer='" + organizer + '\'' +
                ", startDate='" + startDate + '\'' +
                ", descShort='" + descShort + '\'' +
                '}';
    }

    private String getDateAsFormattedString() {
        EventMgrProperties properties = EventMgrProperties.getInstance();
        return this.getStartDateAsLocalDate().format(properties.getDateFormatAsDateTimeFormatter());
    }

    class Place {

        @JsonProperty("name")
        String name;

        public Place() {

        }

        public Place(String name) {
            this.name = name;

        }

        public String getName() {
            return name;
        }
    }

    class Organizer {
        String designation;

        public Organizer() {
        }

        public Organizer(String designation) {
            this.designation = designation;
        }

        public String getDesignation() {
            return designation;
        }
    }

}
