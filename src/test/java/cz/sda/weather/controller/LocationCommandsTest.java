package cz.sda.weather.controller;

import cz.sda.weather.persistence.Location;
import cz.sda.weather.service.LocationService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class LocationCommandsTest {

    @Test
    void saveLocation() {
        var service = new LocationService() {
            @Override
            public void saveLocation(String city, String country) {
                assertThat(city).isEqualTo("Prague");
                assertThat(country).isEqualTo("Czech Republic");
            }

            @Override
            public List<Location> listLocations() {
                fail("Save location shouldn't invoke listLocations");
                return null;
            }
        };
        var cut = new LocationCommands(service);
        cut.saveLocation("Prague", "Czech Republic");
    }

    @Test
    void listLocations() {
        var service = new LocationService() {
            @Override
            public void saveLocation(String city, String country) {
                fail("List locations shouldn't invoke saveLocation");
            }

            @Override
            public List<Location> listLocations() {
                var l1 = new Location();
                var l2 = new Location();
                l1.setCity("Kosice");
                l1.setCountry("Slovakia");
                l2.setCity("Brno");
                l2.setCountry("Czech Republic");
                return List.of(l1, l2);
            }
        };
        var cut = new LocationCommands(service);
        assertThat(cut.listLocations()).isEqualTo("Kosice (Slovakia)\nBrno (Czech Republic)");
    }
}