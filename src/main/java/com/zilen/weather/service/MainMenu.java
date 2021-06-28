package com.zilen.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu {

    public void createMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("1. Enter city name\n" +
                "2. Log out");
        switch (in.nextInt()) {
            case 1:
                System.out.println("Enter the name of the city:");
                Scanner city = new Scanner(System.in);
                String cityName = city.nextLine();
                WeatherService weatherRedirectService = new WeatherService(new ObjectMapper());
                weatherRedirectService.findByCityName(cityName);
                createMenu();
            case 2:
                break;
        }
    }
}
