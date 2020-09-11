package com.infoshare.eventmanagers.LoadJson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {
    private int id;
    @JsonProperty("name")//bez tego nie działało,
    private String name;
    private String placeName;
    private String organizer;
    private String startDate;

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

    private String descShort;

    //pusty kontruktor, czemu działa?
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

    public int getId() {
        return id;
    }


    public String getStartDate() {
        return startDate;
    }

    public String getDescShort() {
        return descShort;
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
