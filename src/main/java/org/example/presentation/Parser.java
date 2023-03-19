package org.example.presentation;

import org.example.commands.*;

import java.util.NoSuchElementException;

public class Parser {
    public static Command ParseCommand(String line){
        String[] words = line.split(";");
        String[] parameters = new String[words.length - 1];
        System.arraycopy(words, 1, parameters, 0, words.length - 1);
        Command command = getCommand(words[0]);
        if (command == null)
            throw new NoSuchElementException("Unknown command: " + line);
        try {
            command.SetParameters(parameters);
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " " + line);
        }
        return command;
    }

    private static Command getCommand(String verb) {
        Command command = null;
        switch (verb){
            case "RACE": command = new Race();break;
            case "RESULT": command = new Result();break;
            case "FASTEST": command = new Fastest();break;
            case "FINISH": command = new Finish();break;
            case "QUERY": command = new Query();break;
            case "POINT": command = new Point();break;
            case "EXIT": command = new Exit();break;
        }
        return command;
    }
}
