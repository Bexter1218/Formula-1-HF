package org.example.Presentation;

import org.example.Commands.Command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input-hf.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                if(!line.isEmpty()){
                    Command command = Parser.ParseCommand(line);
                    command.Execute();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}