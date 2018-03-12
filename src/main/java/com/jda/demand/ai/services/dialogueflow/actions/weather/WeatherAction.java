package com.jda.demand.ai.services.dialogueflow.actions.weather;


import ai.api.model.AIResponse;
import com.jda.demand.ai.services.dialogueflow.actions.AbstractAction;
import com.jda.demand.ai.services.dialogueflow.actions.weather.model.CurrentWeather;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class WeatherAction extends AbstractAction {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public AIResponse performAction() {
        String city = getAIResponse().getResult().getParameters().get("geo-city").getAsString();
        AIResponse response = getAIResponse();
        try {
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(city, "UTF-8");
            url += "&units=metric&appid=9ac8c51ae0464f86e54491e9bf54a596";
            CurrentWeather weather = restTemplate.getForObject(url, CurrentWeather.class);

            response.getResult().getFulfillment().setSpeech(getWeatherText(weather));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return response;
    }


    private String getWeatherText(CurrentWeather weather) {
        StringBuilder sb = new StringBuilder();
        sb.append("Weather for " + weather.getCityName()).append(" is ")
                .append("Current Temperature " + weather.getMainParameters().getTemperature() + " degree Celsius,")
                .append("Minimum Temperature " + weather.getMainParameters().getMinimumTemperature() + " degree,")
                .append("Maximum Temperature " + weather.getMainParameters().getMaximumTemperature() + " degree,")
                .append("Humidity " + weather.getMainParameters().getHumidity() + "%.");
        return sb.toString();
    }
}
