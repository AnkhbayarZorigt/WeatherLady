package cz.sda.weather.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String country;
}
