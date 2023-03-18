package org.example.Commands;

public interface Command {
    void Execute();
    boolean SetParameters(String[] parameters);
}
