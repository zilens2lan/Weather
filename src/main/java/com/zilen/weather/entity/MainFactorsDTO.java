package com.zilen.weather.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MainFactorsDTO {

    private Float temp;
    private Integer pressure;
    private Integer humidity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
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
        result = ((result * 31) + ((this.humidity == null) ? 0 : this.humidity.hashCode()));
        result = ((result * 31) + ((this.temp == null) ? 0 : this.temp.hashCode()));
        result = ((result * 31) + ((this.pressure == null) ? 0 : this.pressure.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MainFactorsDTO) == false) {
            return false;
        }
        MainFactorsDTO rhs = ((MainFactorsDTO) other);
        return (((((this.humidity == rhs.humidity) || ((this.humidity != null) && this.humidity.equals(rhs.humidity))) && ((this.temp == rhs.temp) || ((this.temp != null) && this.temp.equals(rhs.temp)))) && ((this.pressure == rhs.pressure) || ((this.pressure != null) && this.pressure.equals(rhs.pressure)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }
}
