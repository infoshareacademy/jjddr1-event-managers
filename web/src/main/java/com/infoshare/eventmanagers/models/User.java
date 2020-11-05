package com.infoshare.eventmanagers.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToMany(mappedBy = "userList", fetch = FetchType.LAZY)
    private List<Event> favoriteList = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "Properties_id", referencedColumnName = "id")
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

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
