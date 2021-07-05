package com.zilen.weather.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather {

    @Id
    private Integer id;
    private String name;
    private Float temp;
    private Integer humidity;
    private Integer pressure;
    private Float speed;

    public Weather() {
    }

    public Weather(Integer id, String name, Float temp, Integer humidity, Integer pressure, Float speed) {
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
}
