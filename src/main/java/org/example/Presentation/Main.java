package org.example.Presentation;

import org.example.Commands.Command;
import org.example.Data.Database;
import org.example.Data.MyDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Database db = new MyDatabase();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input-hf.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(!line.isEmpty()){
                    Command command = Parser.ParseCommand(line);
                    command.Execute(db);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}