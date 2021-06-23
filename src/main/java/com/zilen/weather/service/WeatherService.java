package com.zilen.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zilen.weather.entity.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final String appid;

    public void findByCityName(String cityName) {
        WebClient client = WebClient.create();

        String response = client
                .get()
                .uri("api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + appid)
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(response);
            Weather weather = Weather.builder()
                    .id(jsonNode.get("id").asLong())
                    .cityName(jsonNode.get("name").asText())
                    .temp(jsonNode.get("main").get("temp").asDouble())
                    .humidity(jsonNode.get("main").get("humidity").asInt())
                    .pressure(jsonNode.get("main").get("pressure").asInt())
                    .windSpeed(jsonNode.get("wind").get("speed").asDouble())
                    .build();
            System.out.println("Weather in " + weather.getCityName() + ": \n" +
                    "Temperature -> " + weather.getTemp() + "\n" +
                    "Humidity -> " + weather.getHumidity() + "\n" +
                    "Pressure -> " + weather.getPressure() + "\n" +
                    "WindSpeed -> " + weather.getWindSpeed() + "\n");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
