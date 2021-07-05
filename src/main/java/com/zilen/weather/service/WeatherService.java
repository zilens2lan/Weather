package com.zilen.weather.service;

import com.zilen.weather.entity.DTOToWeatherConverter;
import com.zilen.weather.entity.Weather;
import com.zilen.weather.entity.WeatherDTO.WeatherDTO;
import com.zilen.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Service
@PropertySource("classpath:application.properties")
public class WeatherService {

    private final String appid;
    private final String url;
    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;

    public WeatherService(@Value("${com.zilen.appid}") String appid, @Value("${com.zilen.url}") String url, RestTemplate restTemplate, WeatherRepository weatherRepository) {
        this.appid = appid;
        this.url = url;
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
    }

    public WeatherDTO findByCityName(String cityName) {
        assertTrue(cityName != null, "CityName is null!");
        ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appid, WeatherDTO.class);
        DTOToWeatherConverter weather = new DTOToWeatherConverter(response.getBody(), new Weather());
        weatherRepository.save(weather.transform());
        return response.getBody();
    }
}
