package com.zilen.weather.service;

import com.zilen.weather.dto.MainFactorsDto;
import com.zilen.weather.dto.Weather;
import com.zilen.weather.dto.WindDto;
import com.zilen.weather.entity.WeatherEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherConverter {

    public Weather transformToWeather(WeatherEntity weatherEntity) {
        MainFactorsDto mainFactorsDto = new MainFactorsDto();
        mainFactorsDto.setTemp(weatherEntity.getTemp());
        mainFactorsDto.setHumidity(weatherEntity.getHumidity());
        mainFactorsDto.setPressure(weatherEntity.getPressure());

        WindDto windDto = new WindDto();
        windDto.setSpeed(weatherEntity.getSpeed());

        Weather weather = new Weather();
        weather.setId(weatherEntity.getId());
        weather.setName(weatherEntity.getName());
        weather.setMainFactorsDTO(mainFactorsDto);
        weather.setWindDTO(windDto);
        return weather;
    }

    public WeatherEntity transformToEntity(Weather weather){
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setId(weather.getId());
        weatherEntity.setName(weather.getName());
        weatherEntity.setTemp(weather.getMainFactorsDTO().getTemp());
        weatherEntity.setHumidity(weather.getMainFactorsDTO().getHumidity());
        weatherEntity.setPressure(weather.getMainFactorsDTO().getPressure());
        weatherEntity.setSpeed(weather.getWindDTO().getSpeed());
        return weatherEntity;
    }
}
