package com.weatherbot.component;

import com.weatherbot.service.BotConfigService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@RequiredArgsConstructor
@Component
public class WeatherBot extends TelegramLongPollingBot {
    private final BotConfigService botConfigService;
    private final WeatherBotFacade weatherBotFacade;

    @Override
    public String getBotUsername() {
        return botConfigService.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return botConfigService.getBotAccessToken();
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        weatherBotFacade.handleUpdate(update);
    }
}
