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

    public String getAveragedForecast(String city, LocalDate date) {
        List<BigDecimal> temperatures = weatherForecastDownloaders.stream()
                .map(i -> i.getTemperature(city, date))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        BigDecimal avg = temperatures.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(temperatures.size()), RoundingMode.HALF_UP);
        return avg.toString() + " °C";
    }
}
