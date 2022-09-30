package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

public class MessageSenderImplTest {


    @ParameterizedTest
    @ValueSource(strings = {"172."})
    void testMessageSenderRussia(String ip) {
        Map<String, String> headers = new HashMap<>();
        headers.put(IP_ADDRESS_HEADER, ip);
        Country fixCountry = Country.RUSSIA;
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(fixCountry);
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenCallRealMethod();
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String expected = localizationService.locale(fixCountry);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String finishSend = messageSender.send(headers);
        Assertions.assertTrue(finishSend.contains(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {"96."})
    void testMessageSenderUSA(String ip) {
        Map<String, String> headers = new HashMap<>();
        headers.put(IP_ADDRESS_HEADER, ip);
        Country fixCountry = Country.USA;
        Location location = Mockito.mock(Location.class);
        Mockito.when(location.getCountry()).thenReturn(fixCountry);
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ip)).thenCallRealMethod();
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        String expected = localizationService.locale(fixCountry);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String finishSend = messageSender.send(headers);
        Assertions.assertTrue(finishSend.contains(expected));
    }
}
