package com.zilen.weather.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Weather {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "temp")
    private Float temp;
    @Column(name = "humidity")
    private Integer humidity;
    @Column(name = "pressure")
    private Integer pressure;
    @Column(name = "speed")
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
