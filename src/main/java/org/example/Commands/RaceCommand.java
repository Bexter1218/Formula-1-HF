package org.example.Commands;

import org.example.Data.Database;

public class RaceCommand implements Command{
    private int year;
    private String name;
    private int number;
    private double multiplier;
    @Override
    public void Execute(Database database) {
        try {
            database.CreateRace(year, name, number, multiplier);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        if(parameters.length != 4)
            throw new IllegalArgumentException("RACE command should have 4 parameters.");
        try {
            year = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
           throw new IllegalArgumentException("RACE parameter1 should be a number.");
        }
        name = parameters[1];
        try {
            number = Integer.parseInt(parameters[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("RACE parameter3 should be a number.");
        }
        try {
            multiplier = Double.parseDouble(parameters[3]);
            if(multiplier != 0 && multiplier != 0.5 && multiplier != 1 && multiplier != 2)
                throw new IllegalArgumentException("The score multiplier should be 0/0.5/1/2.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("RACE parameter1 should be a decimal.");
        }
        return;
    }
}
