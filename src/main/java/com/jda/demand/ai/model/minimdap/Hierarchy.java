package com.jda.demand.ai.model.minimdap;


import java.util.HashMap;
import java.util.Map;

public class Hierarchy {
    private String name;
    public Map<String, Hierarchy> hierarchy = new HashMap<>();

    public Hierarchy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Hierarchy> getHierarchy() {
        return hierarchy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHierarchy(Map<String, Hierarchy> hierarchy) {
        this.hierarchy = hierarchy;
    }
}
