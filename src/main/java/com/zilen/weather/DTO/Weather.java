package com.zilen.weather.DTO;

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
    private MainFactorsDto mainFactorsDTO;
    @JsonProperty("wind")
    private WindDto windDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MainFactorsDto getMainFactorsDTO() {
        return mainFactorsDTO;
    }

    public void setMainFactorsDTO(MainFactorsDto mainFactorsDTO) {
        this.mainFactorsDTO = mainFactorsDTO;
    }

    public WindDto getWindDTO() {
        return windDTO;
    }

    public void setWindDTO(WindDto windDTO) {
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
        Weather that = (Weather) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(mainFactorsDTO, that.mainFactorsDTO) && Objects.equals(windDTO, that.windDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mainFactorsDTO, windDTO);
    }
}
