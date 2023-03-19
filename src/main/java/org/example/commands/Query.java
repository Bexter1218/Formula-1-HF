package org.example.commands;

import org.example.data.Database;

public class Query implements Command{
    private int year;
    private int number;
    @Override
    public void Execute(Database database) {
        if(number == -1){
            executeYearOnly(database);
            return;
        }
        executeYearAndNumber(database);
    }

    @Override
    public void SetParameters(String[] parameters) {
        number = -1; //the default number for a query
        checkParameterLength(parameters);
        checkFirstParameter(parameters);
        if(parameters.length == 2){
            checkSecondParameter(parameters);
            number = Integer.parseInt(parameters[1]);
        }
    }

    private void executeYearOnly(Database database) {
        System.out.println("Standings in "+ year);
        try {
            database.SelectRaces(year);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void executeYearAndNumber(Database database) {
        try {
            System.out.println("Standings in "+ year + " after race " + number);
            database.SelectRaces(year, number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkParameterLength(String[] parameters) {
        if(parameters.length != 1 && parameters.length != 2)
            throw new IllegalArgumentException("QUERY command should have 1 or 2 parameters.");
    }

    private void checkSecondParameter(String[] parameters) {
        try {
            number = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("QUERY parameter2 should be a number.");
        }
    }
    private void checkFirstParameter(String[] parameters) {
        try {
            year = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("QUERY parameter1 should be a number.");
        }
    }






}