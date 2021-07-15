package com.zilen.weather.exception;

public class CityNotFoundException extends RuntimeException {

    private final String cityName;

    public CityNotFoundException(String message, String cityName) {
        super(message);
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityNotFoundException{" +
                "cityName='" + cityName + '\'' +
                '}';
    }
}



