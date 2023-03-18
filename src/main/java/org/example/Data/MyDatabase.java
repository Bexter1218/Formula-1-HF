package org.example.Data;

import org.example.Commands.PointingMethods;

public class MyDatabase implements Database{
    @Override
    public void CreateRace(int year, String name, int number, double multiplier) {

    }

    @Override
    public void CreateResult(int position, String racer, String team) {

    }

    @Override
    public void FinishRace() {

    }

    @Override
    public void GetStandings(int year) {

    }

    @Override
    public void GetStandings(int year, int number) {

    }

    @Override
    public void SetPointingMethod(PointingMethods pointingMethod) {

    }

    private Race currentRace;
    private Query curretQuery;
}
