package com.zilen.weather.entity;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "speed"
})
public class WindDTO {

    @JsonProperty("speed")
    private Float speed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("speed")
    public Float getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(Float speed) {
        this.speed = speed;
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
        result = ((result* 31)+((this.speed == null)? 0 :this.speed.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WindDTO) == false) {
            return false;
        }
        WindDTO rhs = ((WindDTO) other);
        return (((this.speed == rhs.speed)||((this.speed!= null)&&this.speed.equals(rhs.speed)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }
}
