package com.zilen.weather.service;

import com.zilen.weather.dto.City;
import com.zilen.weather.entity.CityEntity;
import com.zilen.weather.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public CityService(CityRepository cityRepository, CityConverter cityConverter) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }

    public List<City> findAll() {
        List<CityEntity> cityEntities = cityRepository.findAll();
        List<City> cities = new ArrayList<>();
        for (CityEntity city : cityEntities){
            cities.add(cityConverter.transformToCity(city));
        }
        return cities;
    }

    public void addCity(City city) {
        cityRepository.save(cityConverter.transformToEntity(city));
    }

    public void deleteCity(String city) {
        cityRepository.deleteById(city);
    }
}
