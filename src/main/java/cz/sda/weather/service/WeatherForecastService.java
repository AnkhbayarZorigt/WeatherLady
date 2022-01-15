package cz.sda.weather.service;

import cz.sda.weather.persistence.WeatherForecast;

import java.time.LocalDate;

public interface WeatherForecastService {

    WeatherForecast getForecast(String city, LocalDate date);
}
