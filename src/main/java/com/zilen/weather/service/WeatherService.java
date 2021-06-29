package com.zilen.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zilen.weather.entity.WeatherDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Service
@PropertySource("classpath:application.properties")
public class WeatherService {

    private final ObjectMapper objectMapper;
    private final String appid;
    private final String url;
    private final RestTemplate restTemplate;

    private static final Logger logger = LogManager.getLogger(WeatherService.class);

    public WeatherService(ObjectMapper objectMapper, @Value("${appid}") String appid, @Value("${url}") String url, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.appid = appid;
        this.url = url;
        this.restTemplate = restTemplate;
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
