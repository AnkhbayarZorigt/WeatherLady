package cz.sda.weather.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.sda.weather.service.FileWeatherForecastDownloader;
import cz.sda.weather.service.WeatherForecastDownloader;

@Configuration
public class ForecastDownloadersConfiguration {

    @Bean
    public WeatherForecastDownloader firstDownloader() {
        return new FileWeatherForecastDownloader("source1.txt");
    }

    @Bean
    public WeatherForecastDownloader secondDownloader() {
        return new FileWeatherForecastDownloader("source2.txt");
    }

    @Bean
    public WeatherForecastDownloader thirdDownloader() {
        return new FileWeatherForecastDownloader("source3.txt");
    }
}
