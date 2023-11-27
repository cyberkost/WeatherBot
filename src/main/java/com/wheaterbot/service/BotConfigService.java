package com.wheaterbot.service;

import com.wheaterbot.config.BotConfig;
import com.wheaterbot.config.Command;
import com.wheaterbot.repository.BotConfigRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BotConfigService {

    //    private final BotConfigRepo botConfigRepo;
    private final BotConfig botConfig;

    public String getTelegramCallbackAnswerTemp() {
//        return this.botConfigRepo.findAll().get(0).getTelegramCallbackAnswerTemp();
        return botConfig.getTelegramCallbackAnswerTemp();
    }

    public String getNowApiTemp() {
//        return this.botConfigRepo.findAll().get(0).getNowWeatherApiTemp();
        return botConfig.getNowWeatherApiTemp();
    }

    public List<Command> getAllCommands() {
//        return botConfigRepo.findAll().get(0).getCommands();
        return botConfig.getCommands();
    }

    public String getBotUsername() {
//        return botConfigRepo.findAll().get(0).getName();
        return botConfig.getName();
    }

    public String getBotAccessToken() {
//        return botConfigRepo.findAll().get(0).getAccessToken();
        return botConfig.getAccessToken();
    }
}
