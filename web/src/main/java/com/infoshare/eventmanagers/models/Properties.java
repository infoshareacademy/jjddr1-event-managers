package com.infoshare.eventmanagers.models;

import javax.persistence.*;

@Entity
public class Properties {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String sortingOrder;
    @Column
    private boolean ascending;
    @Column
    private String dateFormat;
    @OneToOne(mappedBy = "properties", fetch = FetchType.LAZY)
    private User user;


    public Properties() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}
