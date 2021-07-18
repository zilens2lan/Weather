package com.zilen.weather.quartz;

import com.zilen.weather.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerJob {

    private final WeatherService weatherService;

    public SchedulerJob(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(fixedDelay = 10000)
    public void execute(){
        weatherService.findByCityName("Moscow");
        weatherService.findByCityName("Vitebsk");
        weatherService.findByCityName("London");
    }
}
