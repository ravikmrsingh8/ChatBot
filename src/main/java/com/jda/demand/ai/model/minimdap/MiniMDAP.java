package com.jda.demand.ai.model.minimdap;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiniMDAP {
    private static List<Intersection> intersections = new ArrayList<>();
    public MiniMDAP() {

    }
    static {
        try {
            DataParser.parse("data.csv", intersections);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public List<Intersection> getIntersections() {
        return intersections;
    }

    public List<Forecast> forecasts( Hierarchy product, Hierarchy loc, String measure) {
        Stream<Intersection> intersections = this.getIntersections().parallelStream();
        intersections = applyFilter(intersections, product);
        intersections = applyFilter(intersections, loc);
        List<Intersection> intList = intersections.collect(Collectors.toList());
        return null;
    }

    public Stream<Intersection> applyFilter(Stream<Intersection> stream, Hierarchy hierarchy) {
        for(String name : hierarchy.getHierarchy().keySet()) {
            stream = stream.filter((i)-> {
                return i.getDmdUnitLevel().trim().equalsIgnoreCase(name.trim());
            });
            hierarchy = hierarchy.getHierarchy().get(name);
        }
        return stream;
    }

    public static void main(String[] args) {
        intersections.parallelStream().forEach(i->{
            System.out.println(i);
        });
    }
}
