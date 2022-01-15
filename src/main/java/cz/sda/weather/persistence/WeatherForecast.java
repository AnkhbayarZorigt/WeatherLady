package cz.sda.weather.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class WeatherForecast {
    @Id
    @GeneratedValue
    private Long id;
    private String temperature;
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "location_id", updatable = false)
    private Location location;
}
