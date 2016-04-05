package com.example.melwyn.loginapplication;

/**
 * Created by Melwyn on 05/04/2016.
 */
public class Team {
    private String teamName;
    private int teamId;
    private int teamPoints;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamPoints() {
        return teamPoints;
    }

    public void setTeamPoints(int teamPoints) {
        this.teamPoints = teamPoints;
    }

    @Override
    public String toString() {
        return teamName;
    }
}
