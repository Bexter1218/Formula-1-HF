package org.example.Data;

public class Result {
    public Result(Race race,int position, String racer, String team){
        this.race = race;
        this.position = position;
        this.racer = racer;
        this.team = team;
    }
    private Race race;
    private int position;

    private String racer;
    private String team;

    public int getPosition() {
        return position;
    }

    public String getRacer() {
        return racer;
    }

    public String getTeam() {
        return team;
    }
}
