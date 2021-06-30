package com.zilen.weather.service;

import com.zilen.weather.entity.WeatherDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceTest {

    @Mock
    private RestTemplate restTemplate;
    @Value("${com.zilen.url}")
    private String url;
    @Value("${com.zilen.appid}")
    private String appid;

    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void findByCityName() {
        WeatherDTO weather = new WeatherDTO();
        Mockito
                .when(restTemplate.getForEntity(url + "Moscow&units=metric&appid=" + appid, WeatherDTO.class))
                .thenReturn(new ResponseEntity(weather, HttpStatus.OK));
        WeatherDTO weatherDTO = weatherService.findByCityName("Moscow");
        Assert.assertEquals(weather, weatherDTO);
    }
}