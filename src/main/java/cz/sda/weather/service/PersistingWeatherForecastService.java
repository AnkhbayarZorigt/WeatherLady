package cz.sda.weather.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import cz.sda.weather.persistence.LocationRepository;
import cz.sda.weather.persistence.WeatherForecast;
import cz.sda.weather.persistence.WeatherForecastRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PersistingWeatherForecastService implements WeatherForecastService {

    private final WeatherForecastRepository weatherForecastRepository;
    private final LocationRepository locationRepository;
    private final WeatherForecastAveragingService averagingService;

    @Override
    public WeatherForecast getForecast(String city, LocalDate date) {
        var location = locationRepository
                .findByCity(city)
                .orElseThrow(() -> new IllegalArgumentException(city + " is not a tracked location!"));
        var avgTmp = averagingService.getAveragedForecast(city, date);
        var weatherForecast = new WeatherForecast();
        weatherForecast.setLocation(location);
        weatherForecast.setDate(date);
        weatherForecast.setTemperature(avgTmp + " °C");
        return weatherForecastRepository.save(weatherForecast);
    }
}
