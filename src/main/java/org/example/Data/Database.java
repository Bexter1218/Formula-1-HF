package org.example.Data;

import java.util.Map;

public interface Database {
    void CreateRace(int year, String name, int number, double multiplier) throws Exception;
    void CreateResult(int position, String driver, String team) throws Exception;
    void SetFastest(String driver, String team);
    void FinishRace() throws Exception;
    void SelectRaces(int year) throws Exception;
    void SelectRaces(int year, int number) throws Exception;
    Map<String, Integer> GetDriverStandings(PointingMethods pointingMethod) throws Exception;
    Map<String, Integer> GetTeamStandings(PointingMethods pointingMethod) throws Exception;

}
