package com.example.melwyn.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Melwyn on 05/04/2016.
 */
public class Team implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.teamName);
        dest.writeInt(this.teamId);
        dest.writeInt(this.teamPoints);
    }

    public Team() {
    }

    protected Team(Parcel in) {
        this.teamName = in.readString();
        this.teamId = in.readInt();
        this.teamPoints = in.readInt();
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
