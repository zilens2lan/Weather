package com.zilen.weather.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weather {

    private long id;
    private String cityName;
    private String temp;
    private String pressure;
    private String humidity;
    private String windSpeed;
}
