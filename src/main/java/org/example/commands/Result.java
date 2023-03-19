package org.example.commands;

import org.example.data.Database;

public class Result implements Command{
    private int position;
    private String racer;
    private String team;
    @Override
    public void Execute(Database database) {
        try {
            database.CreateResult(position, racer, team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        checkParametersLegth(parameters);
        checkFirstParameter(parameters);
        racer = parameters[1];
        team = parameters[2];
    }

    private void checkFirstParameter(String[] parameters) {
        try {
            position = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("RESULT parameter1 should be a number.");
        }
    }

    private static void checkParametersLegth(String[] parameters) {
        if(parameters.length != 3)
            throw new IllegalArgumentException("RESULT command should have 3 parameters.");
    }
}
