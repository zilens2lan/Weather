package com.zilen.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zilen.weather.entity.WeatherDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
public class WeatherService {

    private final ObjectMapper objectMapper;
    private final String appid;
    private final String url;

    private static final Logger logger = LogManager.getLogger(WeatherService.class);

    public WeatherService(ObjectMapper objectMapper) {
        this.appid = "50b4a9bfff0df818b269d4a468128442";
        this.url = "https://api.openweathermap.org/data/2.5/weather?q=";
        this.objectMapper = objectMapper;
    }

    public void findByCityName(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url + cityName + "&units=metric&appid=" + appid, String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

        try {
            WeatherDTO weatherDTO = objectMapper.readValue(response.getBody(), WeatherDTO.class);
            System.out.println("Weather in " + weatherDTO.getName() + ": \n" +
                    "Temperature -> " + weatherDTO.getMainFactorsDTO().getTemp() + "\n" +
                    "Humidity -> " + weatherDTO.getMainFactorsDTO().getHumidity() + "\n" +
                    "Pressure -> " + weatherDTO.getMainFactorsDTO().getPressure() + "\n" +
                    "WindSpeed -> " + weatherDTO.getWindDTO().getSpeed() + "\n");
        } catch (IOException e) {
            logger.error("Error in transferring data from JSON to WeatherDTO", e);
        }
    }
}
