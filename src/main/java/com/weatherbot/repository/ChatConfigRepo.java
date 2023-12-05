package com.weatherbot.repository;

import com.weatherbot.config.ChatConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatConfigRepo extends MongoRepository<ChatConfig, Integer> {
    ChatConfig findAllByChatId(Long chatId);

    void deleteByChatId(Long chatId);
}
