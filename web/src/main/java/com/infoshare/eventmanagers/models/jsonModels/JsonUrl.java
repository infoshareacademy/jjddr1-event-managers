package com.infoshare.eventmanagers.models.jsonModels;

import javax.json.bind.annotation.JsonbProperty;

public class JsonUrl {
    @JsonbProperty("www")
    private String www;

    public JsonUrl() {
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }
}
