package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {
    @Test//Проверка возвращаемого текста
    void russianText() {
        Country country = Country.RUSSIA;
        final String text = "Добро пожаловать";
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Assertions.assertEquals(text, localizationService.locale(country));
    }

    @Test//Проверка возвращаемого текста
    void usaText() {
        Country country = Country.USA;
        final String text = "Welcome";
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        Assertions.assertEquals(text, localizationService.locale(country));
    }
}
