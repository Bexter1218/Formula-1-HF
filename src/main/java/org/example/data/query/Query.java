package org.example.data.query;

import org.example.data.race.Race;
import org.example.data.race.Result;

import java.util.*;

public class Query {
    public Query(int year){
        this.year = year;
        this.number = -1;
    }
    public Query(int year, int number) {
        this.year = year;
        this.number = number;
    }
    private final int number;
    private final int year;
    public int getYear() {
        return year;
    }
    public int getNumber(){
        return number;
    }


    public static Map<String, Double> getTeamStandings(PointingMethods method, List<Race> races){
        switch (method){
            case CLASSIC: return getTeamStandings(races, PointingMap.getClassic());
            case MODERN: return getTeamStandings(races, PointingMap.getModern());
            case NEW: return getTeamStandings(races, PointingMap.getNew());
            case PRESENT: return getTeamStandings(races, PointingMap.getPresent());
        }
        return null;
    }
    public static Map<String, Double> getDriverStandings(PointingMethods method, List<Race> races){
        switch (method){
            case CLASSIC: return getDriverStandings(races, PointingMap.getClassic());
            case MODERN: return getDriverStandings(races, PointingMap.getModern());
            case NEW: return getDriverStandings(races, PointingMap.getNew());
            case PRESENT: return getDriverStandings(races, PointingMap.getPresent());
        }
        return null;
    }

    private static Map<String, Double> getDriverStandings(List<Race> races, Map<Integer, Integer> pointing) {
        Map<String, Double> drivers = new HashMap<>();
        for(Race race : races){
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getRacer()))
                    drivers.put(result.getRacer(), 0.0);
                if(pointing.containsKey(result.getPosition())){
                    drivers.put(result.getRacer(), drivers.get(result.getRacer()) + race.getMultiplier() * pointing.get(result.getPosition()));
                }
            }
        }
        return drivers;
    }

    private static Map<String, Double> getTeamStandings(List<Race> races, Map<Integer, Integer> pointing) {
        Map<String, Double> drivers = new HashMap<>();
        for(Race race : races){
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getTeam()))
                    drivers.put(result.getTeam(), 0.0);
                if(pointing.containsKey(result.getPosition())){
                    drivers.put(result.getTeam(), drivers.get(result.getTeam()) + race.getMultiplier() * pointing.get(result.getPosition()));
                }
            }
        }
        return drivers;
    }

}
