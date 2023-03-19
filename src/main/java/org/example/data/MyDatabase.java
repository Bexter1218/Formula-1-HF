package org.example.data;

import org.example.data.query.PointingMethods;
import org.example.data.query.Query;
import org.example.data.race.Race;
import org.example.data.race.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyDatabase implements Database{

    private Race currentRace;
    private final List<Race> races;
    private List<Race> selected;
    public MyDatabase(){
        races = new ArrayList<>();
    }
    @Override
    public  void CreateRace(int year, String name, int number, double multiplier) throws Exception {
        if(currentRace != null)
            throw new Exception("Must finish the previous race before starting a new one.");
        Race race = new Race(year, name, number, multiplier);
        races.add(race);
        currentRace = race;
    }

    @Override
    public  void CreateResult(int position, String driver, String team) throws Exception {
        if(currentRace == null)
            throw new Exception("Open a race first.");
        Result result = new Result(position, driver, team);
        currentRace.AddResult(result);
    }

    @Override
    public  void FinishRace() throws Exception {
        if(currentRace == null)
            throw new Exception("No race to finish.");
        if(currentRace.getResults().size() < 10)
            throw new Exception("A race should have at least 10 results");
        currentRace = null;
    }

    @Override
    public  void SelectRaces(int year) throws Exception {
         if(currentRace != null)
            throw new Exception("Must finish the race before starting a query.");
        if(selected != null)
            throw new Exception("Must finish the previous query before starting a new one.");
        selected = selectRacesByQuery(new Query(year));
    }

    @Override
    public  void SelectRaces(int year, int number) throws Exception {
        if(currentRace != null)
            throw new Exception("Must finish the race before starting a query.");
        if(selected != null)
            throw new Exception("Must finish the previous query before starting a new one.");
        selected = selectRacesByQuery(new Query(year, number));
    }

    @Override
    public Map<String, Double> GetDriverStandings(PointingMethods pointingMethod) throws Exception {
        if(selected == null)
            throw new Exception("Must start a query before.");
        return Query.getDriverStandings(pointingMethod, selected);
    }

    @Override
    public Map<String, Double> GetTeamStandings(PointingMethods pointingMethod) throws Exception {
        if(selected == null)
            throw new Exception("Must start a query before.");
        Map<String, Double> ret = Query.getTeamStandings(pointingMethod, selected);
        selected = null;
        return ret;
    }


    private List<Race> selectRacesByQuery(Query currentQuery){
        List<Race> out = new ArrayList<>();
        for(Race r : races){
            if(r.getYear() == currentQuery.getYear() && (!(r.getNumber() > currentQuery.getNumber())|| currentQuery.getNumber() == -1))
                out.add(r);
        }
        return out;
    }




}
