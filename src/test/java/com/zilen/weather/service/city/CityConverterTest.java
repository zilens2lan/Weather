package com.zilen.weather.service.city;

import com.zilen.weather.dto.City;
import com.zilen.weather.entity.CityEntity;
import com.zilen.weather.service.CityConverter;
import com.zilen.weather.service.city.BaseCityTest;
import org.junit.Assert;
import org.junit.Test;

public class CityConverterTest extends BaseCityTest {

    private final City city = getCity();
    private final CityEntity cityEntity = getCityEntity();
    private final CityConverter cityConverter = new CityConverter();

    @Test
    public void shouldSuccessfullyConvertCityEntityToCity() {
        Assert.assertEquals(city, cityConverter.transformToCity(cityEntity));
    }

    @Test
    public void shouldSuccessfullyConvertWeatherToWeatherEntity() {
        Assert.assertEquals(cityConverter.transformToEntity(city), cityEntity);
    }
}
