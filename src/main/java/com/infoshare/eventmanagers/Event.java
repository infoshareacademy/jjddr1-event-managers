package com.infoshare.eventmanagers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    private int id;
    @JsonProperty("name")
    private String name;
    private String placeName;
    private String organizer;
    private String startDate;
    private String descShort;

    public Event() {
    }

    public String getName() {
        return name;
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


    public String getStartDate() {
        return startDate;
    }

    public String getDescShort() {
        return descShort;
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
