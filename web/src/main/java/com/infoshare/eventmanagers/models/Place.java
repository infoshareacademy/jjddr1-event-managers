package com.infoshare.eventmanagers.models;

import javax.persistence.*;

@Entity
@Table
public class Place {
    @Id
    Integer id;
    @Column
    private String subName;
    @Column
    private String name;
    @OneToOne(mappedBy = "place")
    private Event event;
}
