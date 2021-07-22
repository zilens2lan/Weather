package com.zilen.weather.service;

import com.zilen.weather.dto.City;
import com.zilen.weather.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public CityService(CityRepository cityRepository, CityConverter cityConverter) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }

    public List<City> findAll() {
        return cityRepository.findAll()
                .stream()
                .map(cityConverter::transformToCity)
                .collect(Collectors.toList());
    }

    public void addCity(City city) {
        cityRepository.save(cityConverter.transformToEntity(city));
    }

    public void deleteCity(String city) {
        cityRepository.deleteById(city);
    }
}
