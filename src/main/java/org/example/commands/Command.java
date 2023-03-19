package org.example.commands;

import org.example.data.Database;

public interface Command {
    void Execute(Database database);
    void SetParameters(String[] parameters);
}
