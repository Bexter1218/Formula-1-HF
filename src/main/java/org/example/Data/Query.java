package org.example.Data;

import java.util.*;

public class Query {
    public Query(int year){
        this.year = year;
    }
    private int year;

    public int getYear() {
        return year;
    }
    public int getNumber(){
        return -1;
    }
    public static Map<String, Integer> getStandings(PointingMethods method, List<Race> races){
        switch (method){
            case CLASSIC: return getStandingsClassic(races);
            case MODERN: return getStandingsModern(races);
            case NEW: return getStandingsNew(races);
            case PRESENT: return getStandingsPresent(races);
        }
        return null;
    }

    private static Map<String, Integer> getStandingsPresent(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races){
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getRacer()))
                    drivers.put(result.getRacer(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 25);break;
                    case 2: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 18);break;
                    case 3: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 15);break;
                    case 4: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 12);break;
                    case 5: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 10);break;
                    case 6: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 8);break;
                    case 7: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 6);break;
                    case 8: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 4);break;
                    case 9: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 2);break;
                    case 10: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 1);break;
                }
            }
            drivers.put(race.getFastest().getName(), drivers.get(race.getFastest().getName()) + 1);

        }

        return drivers;
    }

    private static Map<String, Integer> getStandingsNew(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races)
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getRacer()))
                    drivers.put(result.getRacer(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 25);break;
                    case 2: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 18);break;
                    case 3: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 15);break;
                    case 4: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 12);break;
                    case 5: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 10);break;
                    case 6: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 8);break;
                    case 7: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 6);break;
                    case 8: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 4);break;
                    case 9: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 2);break;
                    case 10: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 1);break;

                }
            }
        return drivers;
    }

    private static Map<String, Integer> getStandingsModern(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races)
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getRacer()))
                    drivers.put(result.getRacer(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 10);break;
                    case 2: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 8);break;
                    case 3: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 6);break;
                    case 4: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 5);break;
                    case 5: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 4);break;
                    case 6: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 3);break;
                    case 7: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 2);break;
                    case 8: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 1);break;
                }
            }
        return drivers;
    }

    private static Map<String, Integer> getStandingsClassic(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races)
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getRacer()))
                    drivers.put(result.getRacer(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 10);break;
                    case 2: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 6);break;
                    case 3: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 4);break;
                    case 4: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 3);break;
                    case 5: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 2);break;
                    case 6: drivers.put(result.getRacer(), drivers.get(result.getRacer()) + 1);break;
                }
            }
        return drivers;
    }
}
