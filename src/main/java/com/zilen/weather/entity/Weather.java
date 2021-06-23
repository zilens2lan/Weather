package com.zilen.weather.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Weather {

    private long id;
    private String cityName;
    private double temp;
    private int pressure;
    private int humidity;
    private double windSpeed;
}
