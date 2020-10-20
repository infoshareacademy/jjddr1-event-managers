package com.infoshare.eventmanagers.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table
public class Ticket {

    @Id
    private Integer id;
    @Column
    private String type;
    @OneToOne(mappedBy = "ticket")
    private Event event;

}
