package cz.sda.weather.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import lombok.RequiredArgsConstructor;

import cz.sda.weather.service.WeatherForecastService;

import java.time.LocalDate;

@ShellComponent
@RequiredArgsConstructor
public class WeatherCommands {
    private final WeatherForecastService service;

    @ShellMethod("Download weather forecast")
    public String downloadForecast(
            @ShellOption String city,
            @ShellOption String date) {
        return service.getForecast(city, LocalDate.parse(date)).toString();
    }
}
