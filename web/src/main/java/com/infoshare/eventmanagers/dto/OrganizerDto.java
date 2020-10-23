package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.models.Organizer;

public class OrganizerDto {
    private String id;
    private String designation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public static Organizer toOrganizer(OrganizerDto organizerDto) {

        Organizer organizer = new Organizer();
        organizer.setId(Integer.parseInt(organizerDto.getId()));
        organizer.setDesignation(organizerDto.getDesignation());

        return organizer;
    }
}
