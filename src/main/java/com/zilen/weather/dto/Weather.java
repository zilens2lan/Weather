package com.zilen.weather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Integer id;
    private String name;
    @JsonProperty("main")
    private MainFactors mainFactors;
    private Wind wind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MainFactors getMainFactors() {
        return mainFactors;
    }

    public void setMainFactors(MainFactors mainFactors) {
        this.mainFactors = mainFactors;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
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
        Weather that = (Weather) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mainFactors, that.mainFactors) && Objects.equals(wind, that.wind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mainFactors, wind);
    }
}
