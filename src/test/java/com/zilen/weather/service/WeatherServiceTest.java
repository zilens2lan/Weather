package com.zilen.weather.service;

import com.zilen.weather.entity.MainFactorsDTO;
import com.zilen.weather.entity.WeatherDTO;
import com.zilen.weather.entity.WindDTO;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherServiceTest {

    private RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
    private String url = "url";
    private String appid = "appid";

    private WeatherService weatherService = new WeatherService(appid, url, restTemplate);

    @Test
    public void findByCityName() {
        MainFactorsDTO mainFactorsDTO = new MainFactorsDTO();
        mainFactorsDTO.setHumidity(87);
        mainFactorsDTO.setPressure(1003);
        mainFactorsDTO.setTemp(22.4f);
        WindDTO windDTO = new WindDTO();
        windDTO.setSpeed(18.5f);
        WeatherDTO weather = new WeatherDTO();
        weather.setName("Moscow");
        weather.setMainFactorsDTO(mainFactorsDTO);
        weather.setWindDTO(windDTO);

        Mockito
                .when(restTemplate.getForEntity(url + "Moscow&units=metric&appid=" + appid, WeatherDTO.class))
                .thenReturn(new ResponseEntity(weather, HttpStatus.OK));
        WeatherDTO weatherDTO = weatherService.findByCityName("Moscow");
        Mockito.verify(restTemplate).getForEntity(url + "Moscow&units=metric&appid=" + appid, WeatherDTO.class);
        Assert.assertEquals(weather, weatherDTO);
    }
}