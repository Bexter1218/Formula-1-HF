package org.example.Commands;

import org.example.Data.Database;
import org.example.Data.PointingMethods;

import java.util.Comparator;
import java.util.Map;

public class PointCommand implements Command{
    private PointingMethods method;
    @Override
    public void Execute(Database database) {
        try {
            Map<String, Integer> standings = database.GetStandings(method);
            standings.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(System.out::println);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        if(parameters.length != 1)
            throw new IllegalArgumentException("POINT command should have 1 parameters.");
        try {
            method = PointingMethods.valueOf(parameters[0]);
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }

        return;
    }
}