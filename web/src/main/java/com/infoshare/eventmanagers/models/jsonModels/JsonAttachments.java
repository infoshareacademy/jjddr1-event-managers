package com.infoshare.eventmanagers.models.jsonModels;

public class JsonAttachments {
    private String fileName;

    public JsonAttachments() {
    }

    public JsonAttachments(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
