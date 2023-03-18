package org.example.Presentation;

import org.example.Commands.*;

import java.util.NoSuchElementException;

public class Parser {
    public static Command ParseCommand(String line){
        String[] words = line.split(";");
        String[] parameters = new String[words.length - 1];
        for(int i = 0; i < words.length - 1; i++)
            parameters[i] = words[i+1];
        Command command = getCommand(words[0]);
        if (command == null)
            throw new NoSuchElementException("Unknown command.");
        command.SetParameters(parameters);
        return command;
    }

    private static Command getCommand(String verb) {
        Command command = null;
        switch (verb){
            case "RACE": command = new RaceCommand();
            case "RESULT": command = new ResultCommand();
            case "FASTEST": command = new FastestCommand();
            case "FINISH": command = new FinishCommand();
            case "QUERY": command = new QueryCommand();
            case "POINT": command = new PointCommand();
            case "EXIT": command = new ExitCommand();
        }
        return command;
    }
}
