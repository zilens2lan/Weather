package com.zilen.weather.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Scanner;

@Component
public class MainMenu {

    private final String appid = "50b4a9bfff0df818b269d4a468128442";

    @PostConstruct
    public void inputData(){
        Scanner in = new Scanner(System.in);
        System.out.println("1. Enter city name\n" +
                "2. Log out");
        switch (in.nextInt()){
            case 1:
                System.out.println("Enter the name of the city:");
                Scanner city = new Scanner(System.in);
                String cityName = city.nextLine();
                WeatherService weatherRedirectService = new WeatherService(appid);
                weatherRedirectService.findByCityName(cityName);
                inputData();
            case 2: break;
        }
    }
}
