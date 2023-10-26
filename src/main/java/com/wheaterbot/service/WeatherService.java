package com.wheaterbot.service;

import com.wheaterbot.component.WeatherRestMap;
import com.wheaterbot.model.WeatherNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    @Autowired
    private WeatherRestMap weatherRestMap;

    public boolean isCity(String city) throws IOException {
        return weatherRestMap.isCity(city);
    }

    public WeatherNow getCurrentWeather(String city) {
        return weatherRestMap.getNowWeather(city);
    }
}
