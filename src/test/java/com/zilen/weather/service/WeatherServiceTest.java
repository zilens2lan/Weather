package com.zilen.weather.service;

import com.zilen.weather.DTO.MainFactorsDto;
import com.zilen.weather.DTO.Weather;
import com.zilen.weather.DTO.WindDto;
import com.zilen.weather.entity.WeatherEntity;
import com.zilen.weather.repository.WeatherRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherServiceTest {

    private final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private final String url = "url";
    private final String appid = "appid";
    private final WeatherRepository weatherRepository = Mockito.mock(WeatherRepository.class);
    private final WeatherConverter weatherConverter = Mockito.mock(WeatherConverter.class);

    private final Weather weather = new Weather();
    private final WeatherEntity weatherEntity = new WeatherEntity();

    private final WeatherService weatherService = new WeatherService(appid, url, restTemplate, weatherRepository, weatherConverter);

    @Before
    public void init() {
        MainFactorsDto mainFactorsDto = new MainFactorsDto();
        mainFactorsDto.setHumidity(87);
        mainFactorsDto.setPressure(1003);
        mainFactorsDto.setTemp(22.4f);
        WindDto windDto = new WindDto();
        windDto.setSpeed(18.5f);
        weather.setId(42055116);
        weather.setName("Moscow");
        weather.setMainFactorsDTO(mainFactorsDto);
        weather.setWindDTO(windDto);

        weatherEntity.setId(42055116);
        weatherEntity.setName("Moscow");
        weatherEntity.setTemp(22.4f);
        weatherEntity.setHumidity(87);
        weatherEntity.setPressure(1003);
        weatherEntity.setSpeed(18.5f);
    }

    @Test
    public void findByCityName() {
        Mockito
                .when(restTemplate.getForEntity(url + "Moscow&units=metric&appid=" + appid, Weather.class))
                .thenReturn(new ResponseEntity(weather, HttpStatus.OK));
        Mockito
                .when(weatherRepository.findByName("Moscow"))
                .thenReturn(weatherEntity);
        Mockito
                .when(weatherConverter.transformToWeather(weatherEntity))
                .thenReturn(weather);
        Mockito
                .when(weatherConverter.transformToEntity(weather))
                .thenReturn(weatherEntity);

        Weather weatherFromService = weatherService.findByCityName("Moscow");

        Mockito.verify(restTemplate).getForEntity(url + "Moscow&units=metric&appid=" + appid, Weather.class);
        Mockito.verify(weatherRepository).findByName("Moscow");

        Assert.assertEquals(weather, weatherFromService);
    }
}