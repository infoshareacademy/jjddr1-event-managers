package com.infoshare.eventmanagers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Event {
    private int id;
    @JsonProperty("name")
    private String name;
    private String placeName;
    private String organizer;
    private LocalDate startDate;
    @JsonProperty("descShort")
    private String descShort;

    public Event() {
    }

    @JsonProperty("place")
    public void setPlaceName(Place place) {
        this.placeName = place.getName();
    }

    @JsonProperty("organizer")
    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer.getDesignation();
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

    public void printMe() {
        for (int i = 0; i < 160; i++) {
            System.out.print("─");
        }
        System.out.println();
        System.out.println("| Nazwa: " + name);
        System.out.println("| Miejsce: " + placeName);
        System.out.println("| Organizator: " + organizer);
        System.out.println("| Data rozpoczęcia: " + startDate);
        System.out.println("| Krótki opis: " + descShort);


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
