package org.example.Commands;

import org.example.Data.Database;

public class QueryCommand implements Command{
    private int year;
    private int number;
    @Override
    public void Execute(Database database) {
        if(number == -1){
            System.out.println("Standings in "+ year);
            try {
                database.SelectRaces(year);
            } catch (Exception e) {
                System.out.println(e);
            }
            return;
        }
        try {
            System.out.println("Standings in "+ year + " after race " + number);
            database.SelectRaces(year, number);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        number = -1;
        if(parameters.length != 1 && parameters.length != 2)
            throw new IllegalArgumentException("QUERY command should have 1 or 2 parameters.");
        try {
            year = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("QUERY parameter1 should be a number.");
        }
        if(parameters.length == 2){
            try {
                number = Integer.parseInt(parameters[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("QUERY parameter2 should be a number.");
            }
        }
        return;
    }
}