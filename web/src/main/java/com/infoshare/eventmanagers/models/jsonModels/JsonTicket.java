package com.infoshare.eventmanagers.models.jsonModels;

public class JsonTicket {
    private String type;

    public JsonTicket() {
    }

    public JsonTicket(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
