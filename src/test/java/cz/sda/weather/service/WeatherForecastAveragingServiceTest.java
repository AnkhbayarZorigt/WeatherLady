package cz.sda.weather.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherForecastAveragingServiceTest {

    @Test
    void test() {
        var cut = new WeatherForecastAveragingService(List.of(
                (city, date) -> new BigDecimal("10.5"),
                (city, date) -> null,
                (city, date) -> new BigDecimal("10.7"),
                (city, date) -> new BigDecimal("10.3")
        ));

        assertThat(cut.getAveragedForecast(null, null))
                .isEqualTo(new BigDecimal("10.5"));
    }
}