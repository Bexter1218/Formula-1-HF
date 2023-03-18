package org.example.Data;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public Race(int year, String name, int number, double multiplier){
        this.year = year;
        this.name = name;
        this.number = number;
        this.multiplier = multiplier;
        this.results = new ArrayList<>();
    }
    private int year;
    private String name;
    private int number;
    private double multiplier;
    private List<Result> results;
    private Driver fastest;

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public Driver getFastest() {
        return fastest;
    }

    public void setFastest(Driver fastest) {
        this.fastest = fastest;
    }

    public List<Result> getResults() {
        return results;
    }

    public void AddResult(Result result){
        results.add(result);
    }
}
