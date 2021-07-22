package com.zilen.weather.service;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.entity.WeatherEntity;
import com.zilen.weather.exception.CityNotFoundException;
import com.zilen.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class WeatherService {

    @Value("${com.zilen.appid}")
    private String appId;
    @Value("${com.zilen.url}")
    private String url;
    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;
    private final WeatherConverter weatherConverter;

    public WeatherService(RestTemplate restTemplate, WeatherRepository weatherRepository, WeatherConverter weatherConverter) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
        this.weatherConverter = weatherConverter;
    }

    public Weather findByCityNameFromApi(String cityName) {
        ResponseEntity<Weather> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appId, Weather.class);
        return weatherConverter
                .transformToWeather(weatherRepository
                                .save(weatherConverter
                                .transformToEntity(response.getBody())));
    }

    public Weather findByCityName(String cityName) {
        if (cityName.isBlank()) {
            throw new CityNotFoundException("You must pass the correct cityName!", cityName);
        }
        WeatherEntity weatherEntity = weatherRepository.findByName(cityName);
        if (Objects.nonNull(weatherEntity)) {
            return weatherConverter.transformToWeather(weatherEntity);
        }
        return findByCityNameFromApi(cityName);
    }

    public String getAppId() {
        return appId;
    }

    public String getUrl() {
        return url;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
