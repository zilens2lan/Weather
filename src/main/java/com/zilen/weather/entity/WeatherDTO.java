package com.zilen.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    @JsonProperty("main")
    private MainFactorsDTO mainFactorsDTO;
    @JsonProperty("wind")
    private WindDTO windDTO;
    private String name;

    public MainFactorsDTO getMainFactorsDTO() {
        return mainFactorsDTO;
    }

    public void setMainFactorsDTO(MainFactorsDTO mainFactorsDTO) {
        this.mainFactorsDTO = mainFactorsDTO;
    }

    public WindDTO getWindDTO() {
        return windDTO;
    }

    public void setWindDTO(WindDTO windDTO) {
        this.windDTO = windDTO;
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
        WeatherDTO that = (WeatherDTO) o;
        return Objects.equals(mainFactorsDTO, that.mainFactorsDTO) && Objects.equals(windDTO, that.windDTO) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainFactorsDTO, windDTO, name);
    }
}
