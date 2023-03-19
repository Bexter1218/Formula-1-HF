package org.example.data.race;

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
    private final int year;
    private final int number;
    private final String name;
    private final double multiplier;
    private final List<Result> results;

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getNumber() {
        return number;
    }

    public double getMultiplier() {
        return multiplier;
    }


    public List<Result> getResults() {
        return results;
    }

    public void AddResult(Result result){
        results.add(result);
    }
}
