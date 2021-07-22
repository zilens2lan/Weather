package com.zilen.weather.service.city;

import com.zilen.weather.dto.City;
import com.zilen.weather.entity.CityEntity;
import com.zilen.weather.repository.CityRepository;
import com.zilen.weather.service.CityConverter;
import com.zilen.weather.service.CityService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class CityServiceTest extends BaseCityTest {

    private final City city = getCity();
    private final CityEntity cityEntity = getCityEntity();
    private final CityRepository cityRepository = Mockito.mock(CityRepository.class);
    private final CityConverter cityConverter = Mockito.mock(CityConverter.class);
    private final CityService cityService = new CityService(cityRepository, cityConverter);

    @Test
    public void shouldSuccessfullyRequestAndReturnListCity() {
        List<CityEntity> cityEntities = List.of(getCityEntity());
        List<City> cities = List.of(getCity());

        Mockito.when(cityRepository.findAll())
                .thenReturn(cityEntities);
        Mockito.when(cityConverter.transformToCity(cityEntity))
                .thenReturn(city);

        List<City> citiesFromService = cityService.findAll();

        Mockito.verify(cityRepository).findAll();
        Mockito.verify(cityConverter).transformToCity(cityEntity);

        Assert.assertEquals(cities.size(), citiesFromService.size());
        Assert.assertEquals(cities.get(0), citiesFromService.get(0));
    }
}