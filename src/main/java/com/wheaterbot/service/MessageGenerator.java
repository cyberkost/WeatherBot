package com.wheaterbot.service;

import com.vdurmont.emoji.EmojiParser;
import com.wheaterbot.model.WeatherNow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageGenerator {
    private final BotConfigService botConfigService;
    private final WeatherService weatherService;
    private String message;

    public String generateStartMessage(String name) {
        return EmojiParser.parseToUnicode("Hallo, " + name + " :wave: \nTo find how use me - enter /help");
    }

    public String generateHelpMessage() {
        message = "";
        message = ":sunny: My commands :sunny:\n\n";
        botConfigService.getAllCommands()
                .forEach(command -> {
                    message = message + command.getName() + " - " + command.getDescription() + "\n";
                });
        return EmojiParser.parseToUnicode(message);
    }

    public String generateSuccessCancel() {
        return EmojiParser.parseToUnicode(":white_check_mark: Active command successfully rejected");
    }

    public String generateSuccessSetCity(String city) {
        return EmojiParser.parseToUnicode(":white_check_mark: New standard city" + city);
    }

    public String generateErrorCity() {
        return EmojiParser.parseToUnicode(":x: There is no such city");
    }

    public String generateSuccessGetCity(String city) {
        return EmojiParser.parseToUnicode(":cityscape: Standard city - " + city);
    }

    public String generateErrorGetCity() {
        return EmojiParser.parseToUnicode(":x: No default city assigned");
    }

    public String generateCurrentWeather(String city) {
        WeatherNow weatherNow = weatherService.getCurrentWeather(city);
        return EmojiParser.parseToUnicode("Current weather\n\n" +
                "In city " + city + " " + weatherNow.getWeather().get(0).getDescription() + "\n" +
                ":thermometer: Temperature: " + weatherNow.getMain().getTemp() + "°C, feels like " + weatherNow.getMain().getFeelsLike() + "°C");
    }
}
