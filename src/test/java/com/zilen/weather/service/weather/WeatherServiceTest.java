package com.zilen.weather.service.weather;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.entity.WeatherEntity;
import com.zilen.weather.repository.WeatherRepository;
import com.zilen.weather.service.WeatherConverter;
import com.zilen.weather.service.WeatherService;
import com.zilen.weather.service.weather.BaseWeatherTest;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherServiceTest extends BaseWeatherTest {

    private final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private final String url = "url";
    private final String appId = "appid";
    private final WeatherRepository weatherRepository = Mockito.mock(WeatherRepository.class);
    private final WeatherConverter weatherConverter = Mockito.mock(WeatherConverter.class);

    private final Weather weather = getWeather();
    private final WeatherEntity weatherEntity = getWeatherEntity();

    private final WeatherService weatherService = new WeatherService(restTemplate, weatherRepository, weatherConverter);

    @Test
    public void shouldSuccessfullyRequestAndReturnWeather() {
        weatherService.setAppId(appId);
        weatherService.setUrl(url);
        Mockito
                .when(restTemplate.getForEntity(url + "Moscow&units=metric&appid=" + appId, Weather.class))
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

        Mockito.verify(restTemplate).getForEntity(url + "Moscow&units=metric&appid=" + appId, Weather.class);
        Mockito.verify(weatherRepository).findByName("Moscow");
        Mockito.verify(weatherConverter).transformToWeather(weatherEntity);
        Mockito.verify(weatherConverter).transformToEntity(weather);

        Assert.assertEquals(weather, weatherFromService);
    }
}