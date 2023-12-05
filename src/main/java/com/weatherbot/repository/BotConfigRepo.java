package com.weatherbot.repository;

import com.weatherbot.config.BotConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BotConfigRepo extends MongoRepository<BotConfig, Integer> {
}
