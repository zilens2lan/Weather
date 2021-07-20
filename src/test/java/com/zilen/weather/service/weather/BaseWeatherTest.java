package com.zilen.weather.service.weather;

import com.zilen.weather.dto.MainFactors;
import com.zilen.weather.dto.Weather;
import com.zilen.weather.dto.Wind;
import com.zilen.weather.entity.WeatherEntity;

public abstract class BaseWeatherTest {

    public WeatherEntity getWeatherEntity(){
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setId(42055116);
        weatherEntity.setName("Moscow");
        weatherEntity.setTemp(22.4f);
        weatherEntity.setHumidity(87);
        weatherEntity.setPressure(1003);
        weatherEntity.setSpeed(18.5f);
        return weatherEntity;
    }

    public Weather getWeather(){
        Weather weather = new Weather();
        MainFactors mainFactors = new MainFactors();
        mainFactors.setHumidity(87);
        mainFactors.setPressure(1003);
        mainFactors.setTemp(22.4f);

        Wind wind = new Wind();
        wind.setSpeed(18.5f);

        weather.setId(42055116);
        weather.setName("Moscow");
        weather.setMainFactors(mainFactors);
        weather.setWind(wind);
        return weather;
    }
}
