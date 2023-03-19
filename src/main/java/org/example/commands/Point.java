package org.example.commands;

import org.example.data.Database;
import org.example.data.query.PointingMethods;

import java.util.Comparator;
import java.util.Map;

public class Point implements Command{
    private PointingMethods method;
    @Override
    public void Execute(Database database) {
        try {
            printDriverStandings(database);
            printTeamStandings(database);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void SetParameters(String[] parameters) {
        checkParametersLength(parameters);
        try {
            method = PointingMethods.valueOf(parameters[0]);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    private void printDriverStandings(Database database) throws Exception {
        System.out.println("Drivers:");
        Map<String, Double> standings = database.GetDriverStandings(method);
        standings.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    private void printTeamStandings(Database database) throws Exception {
        System.out.println("Teams:");
        Map<String, Double> standings = database.GetTeamStandings(method);
        standings.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

    private static void checkParametersLength(String[] parameters) {
        if(parameters.length != 1)
            throw new IllegalArgumentException("POINT command should have 1 parameters.");
    }
}