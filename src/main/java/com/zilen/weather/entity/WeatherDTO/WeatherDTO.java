package com.zilen.weather.entity.WeatherDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    private Integer id;
    private String name;
    @JsonProperty("main")
    private MainFactorsDTO mainFactorsDTO;
    @JsonProperty("wind")
    private WindDTO windDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mainFactorsDTO, that.mainFactorsDTO) && Objects.equals(windDTO, that.windDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mainFactorsDTO, windDTO);
    }
}
