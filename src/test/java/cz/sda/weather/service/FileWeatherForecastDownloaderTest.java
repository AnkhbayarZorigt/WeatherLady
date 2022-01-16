package cz.sda.weather.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class FileWeatherForecastDownloaderTest {

    @Test
    void testExisting() {
        var cut = new FileWeatherForecastDownloader("source1.txt");
        assertThat(cut.getTemperature("Brno", LocalDate.parse("2022-01-13")))
                .isEqualTo(new BigDecimal(-1));
    }

    @Test
    void testNotExisting() {
        var cut = new FileWeatherForecastDownloader("source1.txt");
        assertThat(cut.getTemperature("Dubai", LocalDate.parse("2022-01-13")))
                .isNull();
    }
}