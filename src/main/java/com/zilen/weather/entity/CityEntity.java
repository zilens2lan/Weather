package com.zilen.weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class CityEntity {

    @Id
    private String city;

    public CityEntity(String city) {
        this.city = city;
    }

    public CityEntity() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = this.city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "city='" + city + '\'' +
                '}';
    }
}
