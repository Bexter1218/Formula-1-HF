package org.example.Commands;

import org.example.Data.Database;

public interface Command {
    void Execute(Database database);
    void SetParameters(String[] parameters);
}
