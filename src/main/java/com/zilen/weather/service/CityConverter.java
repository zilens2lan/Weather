package com.zilen.weather.service;

import com.zilen.weather.dto.City;
import com.zilen.weather.entity.CityEntity;
import org.springframework.stereotype.Service;

@Service
public class CityConverter {

    public City transformToCity(CityEntity cityEntity) {
        return new City(cityEntity.getName());
    }

    public CityEntity transformToEntity(City city) {
        return new CityEntity(city.getName());
    }
}
