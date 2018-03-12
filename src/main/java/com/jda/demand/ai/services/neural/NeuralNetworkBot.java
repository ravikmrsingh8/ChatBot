package com.jda.demand.ai.services.neural;


import com.jda.demand.ai.model.BotResponse;


public interface NeuralNetworkBot {
    BotResponse sendRequest(String request) throws Exception;

}
