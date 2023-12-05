package com.weatherbot.config;

import com.weatherbot.enums.BotState;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Document(collection = "chats_config")
public class ChatConfig {
    @Id
    private Integer id;
    @NonNull
    private Long chatId;
    @NonNull
    @Field(targetType = FieldType.STRING)
    private BotState botState;
    private String city;
}
