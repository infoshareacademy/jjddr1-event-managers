package com.infoshare.eventmanagers.models.jsonModels;

import javax.json.bind.annotation.JsonbProperty;

public class JsonPlace {
    private String id;

    private String subName;
    private String name;
    public JsonPlace() {
    }

    public JsonPlace(String id, String subName, String name) {
        this.id = id;
        this.subName = subName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
