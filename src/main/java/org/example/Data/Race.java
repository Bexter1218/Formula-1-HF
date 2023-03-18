package org.example.Data;

public class Race {
    public Race(int year, String name, int number, double multiplier){
        this.year = year;
        this.name = name;
        this.number = number;
        this.multiplier = multiplier;
    }
    private int year;
    private String name;
    private int number;
    private double multiplier;

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
}
