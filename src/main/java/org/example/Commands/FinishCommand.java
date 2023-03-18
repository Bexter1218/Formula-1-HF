package org.example.Commands;

import org.example.Data.Database;

public class FinishCommand implements Command{
    @Override
    public void Execute(Database database) {
        try {
            database.FinishRace();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void SetParameters(String[] parameters) {
        if(parameters.length != 0)
            throw new IllegalArgumentException("FINISH move should have 0 parameters.");
        return;
    }
}