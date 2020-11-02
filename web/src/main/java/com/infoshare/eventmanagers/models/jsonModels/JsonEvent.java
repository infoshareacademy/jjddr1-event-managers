package com.infoshare.eventmanagers.models.jsonModels;

public class JsonEvent {
    private String id;
    private String name;
    private JsonPlace place;
    private String startDate;
    private String endDate;
    private JsonAttachments [] attachments;
    private JsonUrl urls;
    private String descLong;
    private String categoryId;
    private JsonOrganizer organizer;
    private String active;
    private String descShort;
    private JsonTicket tickets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonPlace getPlace() {
        return place;
    }

    public void setPlace(JsonPlace place) {
        this.place = place;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public JsonAttachments[] getAttachments() {
        return attachments;
    }

    public void setAttachments(JsonAttachments[] attachments) {
        this.attachments = attachments;
    }

    public JsonUrl getUrls() {
        return urls;
    }

    public void setUrls(JsonUrl urls) {
        this.urls = urls;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public JsonOrganizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(JsonOrganizer organizer) {
        this.organizer = organizer;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public JsonTicket getTickets() {
        return tickets;
    }

    public void setTickets(JsonTicket tickets) {
        this.tickets = tickets;
    }
}
