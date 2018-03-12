package com.jda.demand.ai.model.minimdap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataParser {
    public static void parse(String file, List<Intersection> intersections) throws IOException {
        InputStream in =  DataParser.class.getClassLoader().getResourceAsStream("data.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine(); // read headings
        while((line = reader.readLine()) != null) {
            String[] lines = {line, reader.readLine(), reader.readLine()};
            Intersection intersection = parseLines(lines);
            intersections.add(intersection);
        }
    }

    private static Intersection parseLines(String[] lines) {
        String[] data = lines[0].split(",");
        Intersection intersection = new Intersection();
        intersection.setDmdUnitLevel(data[0]);
        intersection.setGroupLevel(data[1]);
        intersection.setLocLevel(data[2]);

        intersection.setDmdUnit(data[3]);
        intersection.setDmdGroup(data[4]);
        intersection.setLoc(data[5]);

        for(String  line : lines) {
            String[] measureData = line.split(",");
            List<Forecast> forecasts = new ArrayList<>();
            Calendar cal = Calendar.getInstance();
            cal.set(2016, 0,01);

            for(int i=7;i<measureData.length;i++) {
                Date startDate = cal.getTime();
                Forecast forecast = new Forecast(Double.parseDouble(measureData[i].trim()), startDate);
                forecasts.add(forecast);
                cal.add(Calendar.MONTH, 1);
            }
            intersection.getSalesPlan().put(measureData[6], forecasts);
        }
        return intersection;
    }
}
