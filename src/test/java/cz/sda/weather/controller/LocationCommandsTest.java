package cz.sda.weather.controller;

import cz.sda.weather.persistence.Location;
import cz.sda.weather.service.LocationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LocationCommandsTest {

    @Test
    void saveLocation() {
        var service = new LocationService() {
            @Override
            public void saveLocation(String city, String country) {
                Assertions.assertEquals("Prague", city);
                Assertions.assertEquals("Czech Republic", country);
            }

            @Override
            public List<Location> listLocations() {
                Assertions.fail();
                return null;
            }
        };
        var cut = new LocationCommands(service);
        cut.saveLocation("Prague", "Czech Republic");
    }
}