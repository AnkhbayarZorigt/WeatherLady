package cz.sda.weather.service;

import cz.sda.weather.persistence.Location;

import java.util.List;

public interface LocationService {
    void saveLocation(String city, String country);

    List<Location> listLocations();
}
