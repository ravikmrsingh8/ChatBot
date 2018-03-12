package com.jda.demand.ai.services;

import com.jda.demand.ai.model.BotResponse;

import javax.servlet.http.HttpSession;

public interface Bot {
    BotResponse infer(String inputText, HttpSession session);
}
