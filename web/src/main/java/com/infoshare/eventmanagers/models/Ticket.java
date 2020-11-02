package com.infoshare.eventmanagers.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String type;
    @OneToOne(mappedBy = "ticket", fetch = FetchType.LAZY)
    private Event event;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
