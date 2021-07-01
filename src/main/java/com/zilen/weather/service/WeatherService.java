package com.zilen.weather.service;

import com.zilen.weather.entity.Weather;
import com.zilen.weather.entity.WeatherDTO.WeatherDTO;
import com.zilen.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        ResponseEntity<WeatherDTO> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appid, WeatherDTO.class);

        Weather weather = new Weather();
        weather.setId(response.getBody().getId());
        weather.setName(response.getBody().getName());
        weather.setTemp(response.getBody().getMainFactorsDTO().getTemp());
        weather.setHumidity(response.getBody().getMainFactorsDTO().getHumidity());
        weather.setPressure(response.getBody().getMainFactorsDTO().getPressure());
        weather.setSpeed(response.getBody().getWindDTO().getSpeed());
        weatherRepository.save(weather);
        return response.getBody();
    }
}
