package cz.sda.weather.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface WeatherForecastDownloader {

    BigDecimal getTemperature(String city, LocalDate date);
}
