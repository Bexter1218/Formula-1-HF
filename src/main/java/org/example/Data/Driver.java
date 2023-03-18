package org.example.Data;

public class Driver {
    public Driver(String name, String team){
        this.name = name;
        this.team = team;
    }

    private String name;
    private String team;

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
