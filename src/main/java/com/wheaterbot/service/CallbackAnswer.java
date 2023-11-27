package com.wheaterbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
@Service
public class CallbackAnswer {
    private final BotConfigService botConfigService;

    public void callbackAnswer(String callbackId) throws IOException, InterruptedException {
        HttpClient telegramApiClient = HttpClient.newHttpClient();
        HttpRequest telegramCallbackAnswerReq = HttpRequest.newBuilder(URI
                        .create(botConfigService
                                .getTelegramCallbackAnswerTemp()
                                .replace("{token}", botConfigService.getBotAccessToken())
                                .replace("{id}", callbackId)))
                .GET().build();
        telegramApiClient.send(telegramCallbackAnswerReq, HttpResponse.BodyHandlers
                .ofString());
    }
}
