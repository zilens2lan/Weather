package com.zilen.weather.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "temp",
        "pressure",
        "humidity"
})
public class MainFactorsDTO {

    @JsonProperty("temp")
    private Float temp;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("temp")
    public Float getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Float temp) {
        this.temp = temp;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.humidity == null)? 0 :this.humidity.hashCode()));
        result = ((result* 31)+((this.temp == null)? 0 :this.temp.hashCode()));
        result = ((result* 31)+((this.pressure == null)? 0 :this.pressure.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
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
        return (((((this.humidity == rhs.humidity)||((this.humidity!= null)&&this.humidity.equals(rhs.humidity)))&&((this.temp == rhs.temp)||((this.temp!= null)&&this.temp.equals(rhs.temp))))&&((this.pressure == rhs.pressure)||((this.pressure!= null)&&this.pressure.equals(rhs.pressure))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }
}
