package com.univer.models;

import java.util.Objects;

public class ApiSection {

    private Integer id;
    private final String title;
    private final String description;

    public ApiSection(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public ApiSection(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiSection that = (ApiSection) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }


}
