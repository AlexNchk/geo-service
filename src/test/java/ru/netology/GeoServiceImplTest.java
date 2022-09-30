package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceImplTest {
    @ParameterizedTest//Проверка страны по IP
    @ValueSource(strings = {"172."})
    void ipCountryRussia(String ip) {
        Country country = Country.RUSSIA;
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Assertions.assertEquals(country, geoService.byIp(ip).getCountry());
    }

    @ParameterizedTest//Проверка страны по IP
    @ValueSource(strings = {"96."})
    void ipCountryUSA(String ip) {
        Country country = Country.USA;
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Assertions.assertEquals(country, geoService.byIp(ip).getCountry());
    }
}
