package com.zilen.weather.service;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.entity.WeatherEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class WeatherConverterTest extends WeatherAndWeatherEntityGetter {

    private final WeatherConverter weatherConverter = Mockito.mock(WeatherConverter.class);
    private final Weather weather = getWeather();
    private final WeatherEntity weatherEntity = getWeatherEntity();

    @Test
    public void transformToWeather() {
        Mockito
                .when(weatherConverter.transformToWeather(weatherEntity))
                .thenReturn(weather);
        Assert.assertEquals(weather, weatherConverter.transformToWeather(weatherEntity));
    }

    @Test
    public void transformToEntity() {
        Mockito
                .when(weatherConverter.transformToEntity(weather))
                .thenReturn(weatherEntity);
        Assert.assertEquals(weatherConverter.transformToEntity(weather), weatherEntity);
    }
}
