package org.example.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyDatabase implements Database{

    private  Race currentRace;
    private List<Race> races;
    private List<Race> selected;
    private List<Result> results;
    public MyDatabase(){
        races = new ArrayList<>();
        results = new ArrayList<>();
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
        Result result = new Result(currentRace, position, driver, team);
        currentRace.AddResult(result);
        results.add(result);
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
        if(selected != null)
            throw new Exception("Must finish the previous query before starting a new one.");
        selected = selectRacesByQuery(new Query(year));
    }

    @Override
    public  void SelectRaces(int year, int number) throws Exception {
        if(selected != null)
            throw new Exception("Must finish the previous query before starting a new one.");
        selected = selectRacesByQuery(new IntermediateQuery(year, number));
    }

    @Override
    public Map<String, Integer> GetDriverStandings(PointingMethods pointingMethod) throws Exception {
        if(selected == null)
            throw new Exception("Must start a query before.");
        Map<String, Integer> ret = Query.getDriverStandings(pointingMethod, selected);
        return ret;
    }

    @Override
    public Map<String, Integer> GetTeamStandings(PointingMethods pointingMethod) throws Exception {
        if(selected == null)
            throw new Exception("Must start a query before.");
        Map<String, Integer> ret = Query.getTeamStandings(pointingMethod, selected);
        selected = null;
        return ret;
    }

    @Override
    public void SetFastest(String driver, String team) {
        currentRace.setFastest(new Driver(driver, team));
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
