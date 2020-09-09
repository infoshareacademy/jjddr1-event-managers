package com.infoshare.eventmanagers.LoadJson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

@JsonIgnoreProperties
public class Event {
    private final int id;
//    private final String name;
//    private final String place;
//    private final URL wwwAdres;
//    private final String organizer;
//    private final String startDate;
//    private final String descShort;


    public Event(@JsonProperty int id
//                 @JsonProperty String name,
//                 @JsonProperty String place,
//                 @JsonProperty URL wwwAdres,
//                 @JsonProperty String organizer,
//                 @JsonProperty String startDate,
//                 @JsonProperty String descShort
                ) {
        this.id = id;
//        this.name = name;
//        this.place = place;
//        this.wwwAdres = wwwAdres;
//        this.organizer = organizer;
//        this.startDate = startDate;
//        this.descShort = descShort;
    }

    public int getId() {
        return id;
    }
//
//    public String getPlace() {
//        return place;
//    }
//
//    public URL getWwwAdres() {
//        return wwwAdres;
//    }
//
//    public String getOrganizer() {
//        return organizer;
//    }
//
//    public String getStartDate() {
//        return startDate;
//    }
//
//    public String getDescShort() {
//        return descShort;
//    }
//
//    @Override
//    public String toString() {
//        return "Event{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", place='" + place + '\'' +
//                ", wwwAdres=" + wwwAdres +
//                ", organizer='" + organizer + '\'' +
//                ", startDate=" + startDate +
//                ", descShort='" + descShort + '\'' +
//                '}';
//    }
}
