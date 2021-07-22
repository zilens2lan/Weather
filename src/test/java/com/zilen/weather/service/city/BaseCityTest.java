package com.zilen.weather.service.city;

import com.zilen.weather.dto.City;
import com.zilen.weather.entity.CityEntity;

public abstract class BaseCityTest {

    public CityEntity getCityEntity() {
        return new CityEntity("Moscow");
    }

    public City getCity() {
        return new City("Moscow");
    }
}
