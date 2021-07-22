package com.zilen.weather.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Objects;

public class City {

    private String name;

    @JsonCreator
    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + name + '\'' +
                '}';
    }
}
