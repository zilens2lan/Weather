package com.zilen.weather.service;

import com.zilen.weather.dto.MainFactors;
import com.zilen.weather.dto.Weather;
import com.zilen.weather.dto.Wind;
import com.zilen.weather.entity.WeatherEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherConverter {

    public Weather transformToWeather(WeatherEntity weatherEntity) {
        MainFactors mainFactors = new MainFactors();
        mainFactors.setTemp(weatherEntity.getTemp());
        mainFactors.setHumidity(weatherEntity.getHumidity());
        mainFactors.setPressure(weatherEntity.getPressure());

        Wind wind = new Wind();
        wind.setSpeed(weatherEntity.getSpeed());

        Weather weather = new Weather();
        weather.setId(weatherEntity.getId());
        weather.setName(weatherEntity.getName());
        weather.setMainFactors(mainFactors);
        weather.setWind(wind);
        return weather;
    }

    public WeatherEntity transformToEntity(Weather weather){
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setId(weather.getId());
        weatherEntity.setName(weather.getName());
        weatherEntity.setTemp(weather.getMainFactors().getTemp());
        weatherEntity.setHumidity(weather.getMainFactors().getHumidity());
        weatherEntity.setPressure(weather.getMainFactors().getPressure());
        weatherEntity.setSpeed(weather.getWind().getSpeed());
        return weatherEntity;
    }
}
