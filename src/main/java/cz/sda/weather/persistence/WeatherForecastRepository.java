package cz.sda.weather.persistence;

import org.springframework.data.repository.CrudRepository;

public interface WeatherForecastRepository extends CrudRepository<WeatherForecast, Long> {
}
