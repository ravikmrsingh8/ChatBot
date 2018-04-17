package com.jda.demand.ai.configuration;


import ai.api.AIConfiguration;
import ai.api.AIDataService;
import com.jda.demand.ai.services.dialogueflow.actions.ActionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BotConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    ActionFactory actionFactory() {
        return new ActionFactory();
    }

    @Bean
    public AIDataService dataService(Environment env){
        String apiKey = env.getProperty("API_AI_CLIENT_KEY");
        AIConfiguration configuration = new AIConfiguration(apiKey);
        AIDataService service = new AIDataService(configuration);
        return service;
    }
}
