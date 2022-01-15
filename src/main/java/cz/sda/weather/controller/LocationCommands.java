package cz.sda.weather.controller;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import lombok.RequiredArgsConstructor;

import cz.sda.weather.persistence.Location;
import cz.sda.weather.service.LocationService;

import java.util.List;
import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class LocationCommands {
    private final LocationService service;

    @ShellMethod("Save new location")
    public void saveLocation(
            @ShellOption String city,
            @ShellOption String country) {
        service.saveLocation(city, country);
    }

    @ShellMethod("Show saved locations")
    public String listLocations() {
        List<Location> locations = service.listLocations();
        return locations.stream()
                .map(l -> l.getCity() + " (" + l.getCountry() + ")")
                .collect(Collectors.joining("\n"));
    }
}
