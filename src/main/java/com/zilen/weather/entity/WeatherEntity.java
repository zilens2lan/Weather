package com.zilen.weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class WeatherEntity {

    @Id
    private Integer id;
    private String name;
    private Float temp;
    private Integer humidity;
    private Integer pressure;
    private Float speed;

    public WeatherEntity() {
    }

    public WeatherEntity(Integer id, String name, Float temp, Integer humidity, Integer pressure, Float speed) {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.speed = speed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherEntity that = (WeatherEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(temp, that.temp) && Objects.equals(humidity, that.humidity) && Objects.equals(pressure, that.pressure) && Objects.equals(speed, that.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, temp, humidity, pressure, speed);
    }
}
