package org.example.Commands;

import org.example.Data.Database;

public class FastestCommand implements Command{
    private String driver;
    private String team;
    @Override
    public void Execute(Database database) {
        database.SetFastest(driver,team);
    }
    @Override
    public void SetParameters(String[] parameters)
    {
        if(parameters.length != 2)
            throw  new IllegalArgumentException("FASTEST command should have 2 parameters.");
        driver = parameters[0];
        team = parameters[1];
        return;
    }
}
