package com.zilen.weather.service;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.entity.WeatherEntity;
import org.junit.Assert;
import org.junit.Test;

public class WeatherConverterTest extends BaseTest {

    private final WeatherConverter weatherConverter = new WeatherConverter();
    private final Weather weather = getWeather();
    private final WeatherEntity weatherEntity = getWeatherEntity();

    @Test
    public void shouldSuccessfullyConvertWeatherEntityToWeather() {
        Assert.assertEquals(weather, weatherConverter.transformToWeather(weatherEntity));
    }

    @Test
    public void shouldSuccessfullyConvertWeatherToWeatherEntity() {
        Assert.assertEquals(weatherConverter.transformToEntity(weather), weatherEntity);
    }
}
