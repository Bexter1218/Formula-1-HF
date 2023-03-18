package org.example.Data;

import org.example.Commands.PointingMethods;

public interface Database {
    void CreateRace(int year, String name, int number, double multiplier);
    void CreateResult(int position, String racer, String team);
    void FinishRace();
    void GetStandings(int year);
    void GetStandings(int year, int number);
    void SetPointingMethod(PointingMethods pointingMethod);
}
