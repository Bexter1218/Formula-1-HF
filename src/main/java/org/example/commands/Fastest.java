package org.example.commands;

import org.example.data.Database;

public class Fastest implements Command{
    private String driver;
    private String team;
    @Override
    public void Execute(Database database) {
        try {
            database.CreateResult(0,driver,team); //the fastest round is stored with position 0
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void SetParameters(String[] parameters)
    {
        checkParametersLength(parameters);
        driver = parameters[0];
        team = parameters[1];
    }

    private static void checkParametersLength(String[] parameters) {
        if(parameters.length != 2)
            throw  new IllegalArgumentException("FASTEST command should have 2 parameters.");
    }
}
