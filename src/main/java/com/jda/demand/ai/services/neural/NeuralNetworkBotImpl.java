package com.jda.demand.ai.services.neural;

import com.jda.demand.ai.model.BotResponse;
import com.jda.demand.ai.model.NeuralNetworkBotRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class NeuralNetworkBotImpl implements  NeuralNetworkBot {
    private static final String uri = "http://52CQYX1J:80/bot/api/infer";

    private RestTemplate client;

    @Autowired
    public NeuralNetworkBotImpl(RestTemplate client) {
        this.client = client;
    }
    @Override
    public BotResponse sendRequest(String request) throws Exception {
        NeuralNetworkBotRequest nReq = new NeuralNetworkBotRequest(request);
        Map<String, String> requestParams = new HashMap<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<NeuralNetworkBotRequest> entity = new HttpEntity<NeuralNetworkBotRequest>(nReq, headers);
        BotResponse  response = client.postForObject(uri, entity, BotResponse.class,  requestParams);
        return response;
    }
}
