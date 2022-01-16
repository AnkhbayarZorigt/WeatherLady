package cz.sda.weather.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeatherForecastAveragingService {

    private final List<WeatherForecastDownloader> weatherForecastDownloaders;

    public BigDecimal getAveragedForecast(String city, LocalDate date) {
        List<BigDecimal> temperatures = weatherForecastDownloaders.stream()
                .map(i -> i.getTemperature(city, date))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (temperatures.size() == 0) {
            throw new IllegalStateException("No weather forecasts to average for " + city + " on " + date);
        }
        return temperatures.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(temperatures.size()), RoundingMode.HALF_UP);
    }
}
