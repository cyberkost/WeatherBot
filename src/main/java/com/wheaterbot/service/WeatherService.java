package com.wheaterbot.service;

import com.wheaterbot.component.WeatherRestMap;
import com.wheaterbot.model.WeatherNow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
@RequiredArgsConstructor
@Service
public class WeatherService {

    private final WeatherRestMap weatherRestMap;

    public boolean isCity(String city) throws IOException {
        return weatherRestMap.isCity(city);
    }

    public WeatherNow getCurrentWeather(String city) {
        return weatherRestMap.getNowWeather(city);
    }
}
