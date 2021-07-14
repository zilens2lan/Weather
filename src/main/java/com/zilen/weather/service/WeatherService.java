package com.zilen.weather.service;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.exception.CityNotFoundException;
import com.zilen.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public Weather findByCityName(String cityName) {
        if (cityName.isBlank()) {
            throw new CityNotFoundException("You must pass the correct cityName!", cityName);
        }
        ResponseEntity<Weather> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appId, Weather.class);
        weatherRepository.save(weatherConverter.transformToEntity(response.getBody()));
        return weatherConverter.transformToWeather(weatherRepository.findByName(cityName));
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
