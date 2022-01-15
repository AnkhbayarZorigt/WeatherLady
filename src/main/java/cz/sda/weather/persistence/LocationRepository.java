package cz.sda.weather.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {

    @Query("select l from Location l")
    List<Location> selectAll();

    @Query("select case when count(l) > 0 then true else false end from Location l where l.city = :city and l.country = :country")
    boolean exists(String city, String country);

    @Query("select l from Location l where l.city = :city")
    Optional<Location> findByCity(String city);
}
