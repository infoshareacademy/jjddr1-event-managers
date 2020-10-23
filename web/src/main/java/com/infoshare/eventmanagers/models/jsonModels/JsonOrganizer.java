package com.infoshare.eventmanagers.models.jsonModels;

public class JsonOrganizer {
    private String id;
    private String designation;

    public JsonOrganizer() {
    }

    public JsonOrganizer(String id, String designation) {
        this.id = id;
        this.designation = designation;
    }

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
}
