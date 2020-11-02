package com.infoshare.eventmanagers.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    private Integer id;
    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<Event> favoriteList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Event> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Event> favoriteList) {
        this.favoriteList = favoriteList;
    }
}
