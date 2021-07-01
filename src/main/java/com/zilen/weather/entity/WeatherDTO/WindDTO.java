package com.zilen.weather.entity.WeatherDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WindDTO {

    private Float speed;

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
        WindDTO windDTO = (WindDTO) o;
        return Objects.equals(speed, windDTO.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed);
    }
}
