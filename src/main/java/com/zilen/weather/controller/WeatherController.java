package com.zilen.weather.controller;

import com.zilen.weather.dto.Weather;
import com.zilen.weather.exception.CityNotFoundException;
import com.zilen.weather.service.WeatherService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city/{cityName}")
    @ResponseStatus(HttpStatus.OK)
    public Weather findByCityName(@PathVariable String cityName) {
        return weatherService.findByCityName(cityName);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<Object> handleCityIsNullException(CityNotFoundException cityNotFoundException) {
        return new ResponseEntity<Object>(cityNotFoundException.toString(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
