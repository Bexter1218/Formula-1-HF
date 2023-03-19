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

    private enum StandingType{
        DRIVER,
        TEAM
    }

    public static Map<String, Integer> getTeamStandings(PointingMethods method, List<Race> races){
        switch (method){
            case CLASSIC: return getTeamStandingsClassic(races);
            case MODERN: return getTeamStandingsModern(races);
            case NEW: return getTeamStandingsNew(races);
            case PRESENT: return getTeamStandingsPresent(races);
        }
        return null;
    }
    public static Map<String, Integer> getDriverStandings(PointingMethods method, List<Race> races){
        switch (method){
            case CLASSIC: return getDriverStandingsClassic(races);
            case MODERN: return getDriverStandingsModern(races);
            case NEW: return getDriverStandingsNew(races);
            case PRESENT: return getDriverStandingsPresent(races);
        }
        return null;
    }

    private static Map<String, Integer> getDriverStandingsPresent(List<Race> races) {
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

    private static Map<String, Integer> getDriverStandingsNew(List<Race> races) {
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

    private static Map<String, Integer> getDriverStandingsModern(List<Race> races) {
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

    private static Map<String, Integer> getDriverStandingsClassic(List<Race> races) {
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

    private static Map<String, Integer> getTeamStandingsClassic(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races)
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getTeam()))
                    drivers.put(result.getTeam(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 10);break;
                    case 2: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 6);break;
                    case 3: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 4);break;
                    case 4: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 3);break;
                    case 5: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 2);break;
                    case 6: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 1);break;
                }
            }
        return drivers;
    }

    private static Map<String, Integer> getTeamStandingsModern(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races)
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getTeam()))
                    drivers.put(result.getTeam(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 10);break;
                    case 2: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 8);break;
                    case 3: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 6);break;
                    case 4: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 5);break;
                    case 5: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 4);break;
                    case 6: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 3);break;
                    case 7: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 2);break;
                    case 8: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 1);break;
                }
            }
        return drivers;
    }

    private static Map<String, Integer> getTeamStandingsNew(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races)
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getTeam()))
                    drivers.put(result.getTeam(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 25);break;
                    case 2: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 18);break;
                    case 3: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 15);break;
                    case 4: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 12);break;
                    case 5: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 10);break;
                    case 6: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 8);break;
                    case 7: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 6);break;
                    case 8: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 4);break;
                    case 9: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 2);break;
                    case 10: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 1);break;
                }
            }
        return drivers;
    }

    private static Map<String, Integer> getTeamStandingsPresent(List<Race> races) {
        Map<String, Integer> drivers = new HashMap<>();
        for(Race race : races){
            for(Result result : race.getResults()){
                if(!drivers.containsKey(result.getTeam()))
                    drivers.put(result.getTeam(), 0);
                switch (result.getPosition()){
                    case 1: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 25);break;
                    case 2: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 18);break;
                    case 3: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 15);break;
                    case 4: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 12);break;
                    case 5: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 10);break;
                    case 6: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 8);break;
                    case 7: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 6);break;
                    case 8: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 4);break;
                    case 9: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 2);break;
                    case 10: drivers.put(result.getTeam(), drivers.get(result.getTeam()) + 1);break;
                }
            }
            drivers.put(race.getFastest().getTeam(), drivers.get(race.getFastest().getTeam()) + 1);
        }
        return drivers;
    }

}
