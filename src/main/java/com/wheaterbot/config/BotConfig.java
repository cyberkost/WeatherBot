package com.wheaterbot.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@PropertySource("application.properties")
@Document(collection = "bot_config")
public class BotConfig {
    @Id
    private BigInteger id;
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String accessToken;
    private String nowWeatherApiTemp;
    private String telegramCallbackAnswerTemp;
    private List<Command> commands;
}
