package com.weatherbot.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@PropertySource("classpath:application.properties")
@Document(collection = "bot_config")
@Component
public class BotConfig {
    @Id
    private Integer id;
    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String accessToken;
    @Value("${bot.api}")
    private String nowWeatherApiTemp;
    @Value("${bot.callback}")
    private String telegramCallbackAnswerTemp;
    @Field("commands")
    private List<Command> commands;
}