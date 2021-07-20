package com.zilen.weather.quartz;

import com.zilen.weather.dto.City;
import com.zilen.weather.service.CityService;
import com.zilen.weather.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerJob {

    private final WeatherService weatherService;
    private final List<City> cities;

    public SchedulerJob(WeatherService weatherService, CityService cityService) {
        this.weatherService = weatherService;
        this.cities = cityService.findAll();
    }

    @Scheduled(fixedDelay = 60000)
    public void execute() {
        cities.forEach(city -> weatherService.findByCityNameFromApi(city.getName()));
    }
}
