package com.zilen.weather.controller;

import com.zilen.weather.dto.City;
import com.zilen.weather.entity.CityEntity;
import com.zilen.weather.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<City> findAll(){
        return cityService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCity(@RequestBody City city){
        cityService.addCity(city);
    }

    @DeleteMapping("/{city}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCity(@PathVariable String city){
        cityService.deleteCity(city);
    }
}
