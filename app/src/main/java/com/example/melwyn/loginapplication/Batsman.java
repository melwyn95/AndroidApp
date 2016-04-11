package com.example.melwyn.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Melwyn on 10/04/2016.
 */
public class Batsman implements Parcelable {
    private int playerId;
    private int playerRuns;
    private int playerMatches;
    private int playerAvg;
    private int playerSr;
    private int playerBest;
    private int playerCatches;
    private int playerStumping;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerRuns() {
        return playerRuns;
    }

    public void setPlayerRuns(int playerRuns) {
        this.playerRuns = playerRuns;
    }

    public int getPlayerMatches() {
        return playerMatches;
    }

    public void setPlayerMatches(int playerMatches) {
        this.playerMatches = playerMatches;
    }

    public int getPlayerAvg() {
        return playerAvg;
    }

    public void setPlayerAvg(int playerAvg) {
        this.playerAvg = playerAvg;
    }

    public int getPlayerSr() {
        return playerSr;
    }

    public void setPlayerSr(int playerSr) {
        this.playerSr = playerSr;
    }

    public int getPlayerBest() {
        return playerBest;
    }

    public void setPlayerBest(int playerBest) {
        this.playerBest = playerBest;
    }

    public int getPlayerCatches() {
        return playerCatches;
    }

    public void setPlayerCatches(int playerCatches) {
        this.playerCatches = playerCatches;
    }

    public int getPlayerStumping() {
        return playerStumping;
    }

    public void setPlayerStumping(int playerStumping) {
        this.playerStumping = playerStumping;
    }

    public void setBatsman(JSONObject jsonObject) {
        try {
            playerId = (int) jsonObject.get("player_id");
            playerRuns = (int) jsonObject.get("player_runs");
            playerMatches = (int) jsonObject.get("player_matches");
            playerAvg = (int) jsonObject.get("player_avg");
            playerSr = (int) jsonObject.get("player_sr");
            playerBest = (int) jsonObject.get("player_best");
            playerCatches = (int) jsonObject.get("player_catches");
            playerStumping = (int) jsonObject.get("player_stumping");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.playerId);
        dest.writeInt(this.playerRuns);
        dest.writeInt(this.playerMatches);
        dest.writeInt(this.playerAvg);
        dest.writeInt(this.playerSr);
        dest.writeInt(this.playerBest);
        dest.writeInt(this.playerCatches);
        dest.writeInt(this.playerStumping);
    }

    public Batsman() {
    }

    protected Batsman(Parcel in) {
        this.playerId = in.readInt();
        this.playerRuns = in.readInt();
        this.playerMatches = in.readInt();
        this.playerAvg = in.readInt();
        this.playerSr = in.readInt();
        this.playerBest = in.readInt();
        this.playerCatches = in.readInt();
        this.playerStumping = in.readInt();
    }

    public static final Parcelable.Creator<Batsman> CREATOR = new Parcelable.Creator<Batsman>() {
        @Override
        public Batsman createFromParcel(Parcel source) {
            return new Batsman(source);
        }

        @Override
        public Batsman[] newArray(int size) {
            return new Batsman[size];
        }
    };
}
