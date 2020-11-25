package com.infoshare.eventmanagers.dto;

import com.infoshare.eventmanagers.models.Organizer;

public class OrganizerDto {
    private Integer id;
    private String designation;


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

    public static Organizer toOrganizer(OrganizerDto organizerDto) {

        Organizer organizer = new Organizer();
        organizer.setId(organizerDto.getId());
        organizer.setDesignation(organizerDto.getDesignation());

        return organizer;
    }

    public static OrganizerDto toOrganizerDto(Organizer organizer) {
        OrganizerDto organizerDto = new OrganizerDto();
        organizerDto.setId(organizer.getId());
        organizerDto.setDesignation(organizer.getDesignation());
        return organizerDto;
    }
}
