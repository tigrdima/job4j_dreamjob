package ru.job4j.dream.model;

import java.io.Serializable;
import java.util.Objects;

public class Post implements Serializable {
    private int id;
    private String name;
    private String description;
    private boolean visible;
    private City city;
    private String created;

    public Post() {
    }

    public Post(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Post(int id, String name, City city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Post(int id, String name) {
        this.name = name;
    }

    public Post(int id, String name, String description, String created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Post(String name, String description, boolean visible, City city, String created) {
        this.name = name;
        this.description = description;
        this.visible = visible;
        this.city = city;
        this.created = created;
    }

    public Post(int id, String name, String description, boolean visible, City city, String created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.visible = visible;
        this.city = city;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return id == post.id;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
