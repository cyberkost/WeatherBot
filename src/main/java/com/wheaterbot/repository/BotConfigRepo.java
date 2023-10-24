package com.wheaterbot.repository;

import com.wheaterbot.config.BotConfig;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
public interface BotConfigRepo extends MongoRepository<BotConfig, BigInteger> {
}
