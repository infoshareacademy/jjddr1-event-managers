package com.infoshare.eventmanagers.models;


import javax.persistence.*;

@Entity
@Table
public class Organizer {
    @Id
    private Integer id;
    @Column
    private String designation;
    @OneToOne(mappedBy = "organizer")
    private Event event;
}
