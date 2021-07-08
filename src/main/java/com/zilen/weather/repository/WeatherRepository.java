package com.zilen.weather.repository;

import com.zilen.weather.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {
    WeatherEntity findByName(String name);
}
