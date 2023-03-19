package org.example.data.race;

public class Result {
    public Result(int position, String racer, String team){
        this.position = position;
        this.racer = racer;
        this.team = team;
    }

    private final int position;

    private final String racer;
    private final String team;

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
