package cz.sda.weather.service;

import org.springframework.core.io.ClassPathResource;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
public class FileWeatherForecastDownloader implements WeatherForecastDownloader {

    private final String fileName;

    @Override
    public BigDecimal getTemperature(String city, LocalDate date) {
        FileReader fr;
        try {
            fr = new FileReader(new ClassPathResource(fileName).getFile());
        } catch (IOException e) {
            return null;
        }
        BufferedReader br = new BufferedReader(fr);
        return br.lines()
                .map(l -> l.split(","))
                .filter(v -> v[0].equals(city))
                .filter(v -> LocalDate.parse(v[1]).equals(date))
                .findFirst()
                .map(v -> new BigDecimal(v[2]))
                .orElse(null);
    }
}
