package com.zilen.weather.controller;

import com.zilen.weather.entity.WeatherDTO.WeatherDTO;
import com.zilen.weather.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    @ResponseStatus(HttpStatus.OK)
    public WeatherDTO findByCityName(@PathVariable String cityName) {
        return weatherService.findByCityName(cityName);
    }
}
