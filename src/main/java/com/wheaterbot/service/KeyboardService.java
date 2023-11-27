package com.wheaterbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class KeyboardService {
    private final ChatConfigService chatConfigService;
    private final InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();

    public String getChooseCityNowButtonData() {
        return "Enter required city";
    }

    public String getCurrentCityNowButton(String city) {
        return "Now " + city;
    }

    public InlineKeyboardMarkup setChooseCityKeyboard(Long chatId) {
        List<InlineKeyboardButton> keyboardRow = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(chatConfigService.getCity(chatId));
        button1.setCallbackData(getCurrentCityNowButton(chatConfigService.getCity(chatId)));

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Another");
        button2.setCallbackData(getChooseCityNowButtonData());

        keyboardRow.add(button1);
        keyboardRow.add(button2);
        keyboard.setKeyboard(List.of(keyboardRow));
        return keyboard;
    }
}
