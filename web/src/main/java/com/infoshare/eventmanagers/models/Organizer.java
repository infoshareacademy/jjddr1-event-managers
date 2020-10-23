package com.infoshare.eventmanagers.models;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Organizer {
    @Id
    private Integer id;
    @Column
    private String designation;

    @OneToMany(mappedBy = "organizer")
    private List<Event> events;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
