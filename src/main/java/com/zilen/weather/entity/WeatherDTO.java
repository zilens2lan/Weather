package com.zilen.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherDTO {

    @JsonProperty("main")
    private MainFactorsDTO mainFactorsDTO;
    @JsonProperty("wind")
    private WindDTO windDTO;
    private String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.mainFactorsDTO == null) ? 0 : this.mainFactorsDTO.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.windDTO == null) ? 0 : this.windDTO.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherDTO) == false) {
            return false;
        }
        WeatherDTO rhs = ((WeatherDTO) other);
        return (((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))) && ((this.mainFactorsDTO == rhs.mainFactorsDTO) || ((this.mainFactorsDTO != null) && this.mainFactorsDTO.equals(rhs.mainFactorsDTO)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.windDTO == rhs.windDTO) || ((this.windDTO != null) && this.windDTO.equals(rhs.windDTO))));
    }
}
