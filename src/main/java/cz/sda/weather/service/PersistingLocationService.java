package cz.sda.weather.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import cz.sda.weather.persistence.Location;
import cz.sda.weather.persistence.LocationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersistingLocationService implements LocationService {
    private final LocationRepository repository;

    @Override
    public void saveLocation(String city, String country) {
        if (repository.exists(city, country)) {
            throw new IllegalArgumentException(city + ", " + country + " already exists!");
        } else {
            var newLocation = new Location();
            newLocation.setCity(city);
            newLocation.setCountry(country);
            repository.save(newLocation);
        }
    }

    @Override
    public List<Location> listLocations() {
        return repository.selectAll();
    }
}
