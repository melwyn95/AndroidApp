package com.example.melwyn.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Melwyn on 08/04/2016.
 */
public class Player implements Parcelable {
    private String playerName;
    private int playerId;
    private int playerSkill;
    private int teamId;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerSkill() {
        return playerSkill;
    }

    public void setPlayerSkill(int playerSkill) {
        this.playerSkill = playerSkill;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.playerName);
        dest.writeInt(this.playerId);
        dest.writeInt(this.playerSkill);
        dest.writeInt(this.teamId);
    }

    public Player() {
    }

    protected Player(Parcel in) {
        this.playerName = in.readString();
        this.playerId = in.readInt();
        this.playerSkill = in.readInt();
        this.teamId = in.readInt();
    }

    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel source) {
            return new Player(source);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };
}
