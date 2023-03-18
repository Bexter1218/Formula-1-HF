package org.example.Commands;

import org.example.Data.Database;
import org.example.Data.Race;

public class ResultCommand implements Command{
    private int position;
    private String racer;
    private String team;
    @Override
    public void Execute(Database database) {
        try {
            database.CreateResult(position, racer, team);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        if(parameters.length != 3)
            throw new IllegalArgumentException("RESULT command should have 3 parameters.");
        try {
            position = Integer.parseInt(parameters[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("RESULT parameter1 should be a number.");
        }
        racer = parameters[1];
        team = parameters[2];
    }
}
