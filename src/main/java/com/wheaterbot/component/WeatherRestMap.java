package com.wheaterbot.component;

import com.wheaterbot.model.WeatherNow;
import com.wheaterbot.service.BotConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@RequiredArgsConstructor
@Component
public class WeatherRestMap {

    private final RestTemplate restTemplate;

    private final BotConfigService botConfigService;

    public WeatherNow getNowWeather(String city) {
        try {
            return restTemplate.getForObject(botConfigService.getNowApiTemp()
                            .replace("{city}", city),
                    WeatherNow.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isCity(String city) throws IOException {
        URL weatherApiUrl = new URL(botConfigService.getNowApiTemp().replace("{city}", city));
        HttpURLConnection weatherApiConnection = (HttpURLConnection) weatherApiUrl.openConnection();
        weatherApiConnection.setRequestMethod("GET");
        weatherApiConnection.connect();
        return weatherApiConnection.getResponseCode() == HttpURLConnection.HTTP_OK;
    }
}
