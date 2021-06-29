package com.zilen.weather.service;

import com.zilen.weather.entity.WeatherDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@PropertySource("classpath:application.properties")
public class WeatherService {

    private String appid;
    private String url;
    private RestTemplate restTemplate;

    public WeatherService(@Value("${com.zilen.appid}") String appid, @Value("${com.zilen.url}") String url, RestTemplate restTemplate) {
        this.appid = appid;
        this.url = url;
        this.restTemplate = restTemplate;
    }

    public WeatherDTO findByCityName(String cityName) {
        ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appid, WeatherDTO.class);
        return response.getBody();
    }
}
