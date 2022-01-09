package cz.sda.weather.service;

import cz.sda.weather.persistence.Location;
import cz.sda.weather.persistence.LocationRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PersistingLocationServiceTest {

    @Test
    void selectAll() {
        var location = new Location();
        location.setId(13L);
        location.setCity("Brno");
        location.setCountry("Czech Republic");
        var repository = new LocationRepository() {
            @Override
            public <S extends Location> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Location> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Location> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Location> findAll() {
                return null;
            }

            @Override
            public Iterable<Location> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Location entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Location> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Location> selectAll() {
                return List.of(location);
            }

            @Override
            public boolean exists(String city, String country) {
                return false;
            }
        };
        var cut = new PersistingLocationService(repository);

        assertThat(cut.listLocations()).contains(location);
    }

    @Test
    void saveExists() {
        var repository = new LocationRepository() {
            @Override
            public <S extends Location> S save(S entity) {
                return null;
            }

            @Override
            public <S extends Location> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Location> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Location> findAll() {
                return null;
            }

            @Override
            public Iterable<Location> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Location entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Location> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Location> selectAll() {
                return null;
            }

            @Override
            public boolean exists(String city, String country) {
                return true;
            }
        };
        var cut = new PersistingLocationService(repository);

        assertThatCode(() -> cut.saveLocation("Brno", "Czech Republic"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void saveNotExists() {
        var repository = new LocationRepository() {
            @Override
            public <S extends Location> S save(S entity) {
                var newLocation = new Location();
                newLocation.setCity("Brno");
                newLocation.setCountry("Czech Republic");
                assertThat(entity).isEqualTo(newLocation);
                return null;
            }

            @Override
            public <S extends Location> Iterable<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public Optional<Location> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Location> findAll() {
                return null;
            }

            @Override
            public Iterable<Location> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Location entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Location> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Location> selectAll() {
                return null;
            }

            @Override
            public boolean exists(String city, String country) {
                return false;
            }
        };
        var cut = new PersistingLocationService(repository);

        cut.saveLocation("Brno", "Czech Republic");
    }
}