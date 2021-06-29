package com.zilen.weather;

import com.zilen.weather.entity.WeatherDTO;
import com.zilen.weather.service.WeatherService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class WeatherApplicationRunner {

    private final WeatherService weatherService;

    public WeatherApplicationRunner(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void createMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Enter city name\n" +
                "2. Log out");
        switch (in.nextInt()) {
            case 1:
                System.out.println("Enter the name of the city:");
                Scanner city = new Scanner(System.in);
                String cityName = city.nextLine();
                WeatherDTO weatherDTO = weatherService.findByCityName(cityName);
                System.out.println("Weather in " + weatherDTO.getName() + ": \n" +
                        "Temperature -> " + weatherDTO.getMainFactorsDTO().getTemp() + "\n" +
                        "Humidity -> " + weatherDTO.getMainFactorsDTO().getHumidity() + "\n" +
                        "Pressure -> " + weatherDTO.getMainFactorsDTO().getPressure() + "\n" +
                        "WindSpeed -> " + weatherDTO.getWindDTO().getSpeed() + "\n");
                createMenu();
            case 2:
                break;
        }
    }
}
