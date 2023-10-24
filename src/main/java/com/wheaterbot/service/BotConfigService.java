package com.wheaterbot.service;

import com.wheaterbot.config.Command;
import com.wheaterbot.repository.BotConfigRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BotConfigService {

    private final BotConfigRepo botConfigRepo;

    public String getTelegramCallbackAnswerTemp() {
        return this.botConfigRepo.findAll().get(0).getTelegramCallbackAnswerTemp();
    }

    public String getNowApiTemp() {
        return this.botConfigRepo.findAll().get(0).getNowWeatherApiTemp();
    }

    public List<Command> getAllCommands() {
        return botConfigRepo.findAll().get(0).getCommands();
    }

    public String getBotName() {
        return botConfigRepo.findAll().get(0).getBotName();
    }

    public String getBotAccessToken() {
        return botConfigRepo.findAll().get(0).getAccessToken();
    }
}
