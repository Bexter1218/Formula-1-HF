package org.example.commands;

import org.example.data.Database;

public class Finish implements Command{
    @Override
    public void Execute(Database database) {
        try {
            database.FinishRace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        checkParametersLength(parameters);
    }

    private static void checkParametersLength(String[] parameters) {
        if(parameters.length != 0)
            throw new IllegalArgumentException("FINISH move should have 0 parameters.");
    }
}