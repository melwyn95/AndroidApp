package com.example.melwyn.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Melwyn on 11/04/2016.
 */
public class Bowler implements Parcelable {
    private int playerId;
    private int playerWickets;
    private int playerOvers;
    private int playerRuns;
    private int playerMatches;
    private int playerAvg;
    private int playerEconomy;
    private String playerBest;
    private int playerMaidens;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerWickets() {
        return playerWickets;
    }

    public void setPlayerWickets(int playerWickets) {
        this.playerWickets = playerWickets;
    }

    public int getPlayerOvers() {
        return playerOvers;
    }

    public void setPlayerOvers(int playerOvers) {
        this.playerOvers = playerOvers;
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

    public int getPlayerEconomy() {
        return playerEconomy;
    }

    public void setPlayerEconomy(int playerEconomy) {
        this.playerEconomy = playerEconomy;
    }

    public String getPlayerBest() {
        return playerBest;
    }

    public void setPlayerBest(String playerBest) {
        this.playerBest = playerBest;
    }

    public int getPlayerMaidens() {
        return playerMaidens;
    }

    public void setPlayerMaidens(int playerMaidens) {
        this.playerMaidens = playerMaidens;
    }

    public void setBowler(JSONObject jsonObject) {
        try {
            playerId = (int) jsonObject.get("player_id");
            playerRuns = (int) jsonObject.get("player_runs");
            playerMatches = (int) jsonObject.get("player_matches");
            playerAvg = (int) jsonObject.get("player_avg");
            playerEconomy = (int) jsonObject.get("player_economy");
            playerBest = (String) jsonObject.get("player_best");
            playerMaidens = (int) jsonObject.get("player_maidens");
            playerWickets = (int) jsonObject.get("player_wickets");
            playerOvers = (int) jsonObject.get("player_overs");
            Log.d("Bowler", playerBest);
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
        dest.writeInt(this.playerWickets);
        dest.writeInt(this.playerOvers);
        dest.writeInt(this.playerRuns);
        dest.writeInt(this.playerMatches);
        dest.writeInt(this.playerAvg);
        dest.writeInt(this.playerEconomy);
        dest.writeString(this.playerBest);
        dest.writeInt(this.playerMaidens);
    }

    public Bowler() {
    }

    protected Bowler(Parcel in) {
        this.playerId = in.readInt();
        this.playerWickets = in.readInt();
        this.playerOvers = in.readInt();
        this.playerRuns = in.readInt();
        this.playerMatches = in.readInt();
        this.playerAvg = in.readInt();
        this.playerEconomy = in.readInt();
        this.playerBest = in.readString();
        this.playerMaidens = in.readInt();
    }

    public static final Parcelable.Creator<Bowler> CREATOR = new Parcelable.Creator<Bowler>() {
        @Override
        public Bowler createFromParcel(Parcel source) {
            return new Bowler(source);
        }

        @Override
        public Bowler[] newArray(int size) {
            return new Bowler[size];
        }
    };
}





