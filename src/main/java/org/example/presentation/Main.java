package org.example.presentation;

import org.example.commands.Command;
import org.example.data.Database;
import org.example.data.MyDatabase;

import java.io.BufferedReader;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}