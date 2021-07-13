package com.zilen.weather.service;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.exception.CityNotFoundException;
import com.zilen.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@PropertySource("classpath:application.properties")
public class WeatherService {

    private final String appid;
    private final String url;
    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;
    private final WeatherConverter weatherConverter;

    public WeatherService(@Value("${com.zilen.appid}") String appid, @Value("${com.zilen.url}") String url, RestTemplate restTemplate, WeatherRepository weatherRepository, WeatherConverter weatherConverter) {
        this.appid = appid;
        this.url = url;
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
        this.weatherConverter = weatherConverter;
    }

    public Weather findByCityName(String cityName) {
        if (!Objects.nonNull(cityName)) {
            throw new CityNotFoundException("You must pass the correct cityName!", cityName);
        }
        ResponseEntity<Weather> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appid, Weather.class);
        weatherRepository.save(weatherConverter.transformToEntity(response.getBody()));
        return weatherConverter.transformToWeather(weatherRepository.findByName(cityName));
    }
}
