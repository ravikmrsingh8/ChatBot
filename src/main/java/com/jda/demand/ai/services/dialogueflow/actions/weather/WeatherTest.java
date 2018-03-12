package com.jda.demand.ai.services.dialogueflow.actions.weather;


import com.jda.demand.ai.services.dialogueflow.actions.weather.model.CurrentWeather;
import org.springframework.web.client.RestTemplate;

public class WeatherTest {
    private static String url = "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=9ac8c51ae0464f86e54491e9bf54a596";
    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        url = String.format(url, "Delhi");
        CurrentWeather weather = template.getForObject(url, CurrentWeather.class);
        System.out.println(weather);
        System.out.println(weather.getCityName());
        System.out.println(weather.getMainParameters().getHumidity());
        System.out.println(weather.getMainParameters().getMaximumTemperature());
        System.out.println(weather.getMainParameters().getMinimumTemperature());

    }
}
