package com.infoshare.eventmanagers.models;

import javax.persistence.*;

@Entity
@Table
public class Place {
    @Id
    private Integer id;
    @Column
    private String subName;
    @Column
    private String name;
    @OneToOne(mappedBy = "place", fetch = FetchType.LAZY)
    private Event event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
