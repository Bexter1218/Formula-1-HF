package org.example.data;

import org.example.data.query.PointingMethods;

import java.util.Map;

public interface Database {
    void CreateRace(int year, String name, int number, double multiplier) throws Exception;
    void CreateResult(int position, String driver, String team) throws Exception;
    void FinishRace() throws Exception;
    void SelectRaces(int year) throws Exception;
    void SelectRaces(int year, int number) throws Exception;
    Map<String, Double> GetDriverStandings(PointingMethods pointingMethod) throws Exception;
    Map<String, Double> GetTeamStandings(PointingMethods pointingMethod) throws Exception;

}
