package com.zilen.weather.entity;

import com.zilen.weather.entity.WeatherDTO.WeatherDTO;

public class DTOToWeatherConverter {

    private final WeatherDTO weatherDTO;
    private final Weather weather;

    public DTOToWeatherConverter(WeatherDTO weatherDTO, Weather weather) {
        this.weatherDTO = weatherDTO;
        this.weather = weather;
    }

    public Weather transform() {
        weather.setId(weatherDTO.getId());
        weather.setName(weatherDTO.getName());
        weather.setTemp(weatherDTO.getMainFactorsDTO().getTemp());
        weather.setHumidity(weatherDTO.getMainFactorsDTO().getHumidity());
        weather.setPressure(weatherDTO.getMainFactorsDTO().getPressure());
        weather.setSpeed(weatherDTO.getWindDTO().getSpeed());
        return weather;
    }
}
