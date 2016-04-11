package com.example.melwyn.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melwyn on 08/04/2016.
 */
public class PlayerDataProvider implements Parcelable {
    private List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(JSONArray jsonArray) {
        Player player = null;
        for (int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = (JSONObject) jsonArray.get(i);
                player = new Player();
                Log.d("PlayerDataProvider", "Before Setting Json Data");
                Log.d("PlayerDataProvider", (String) jsonObject.get("player_name"));
                player.setTeamId((Integer) jsonObject.get("team_id"));
                player.setPlayerId((Integer) jsonObject.get("player_id"));
                player.setPlayerName((String) jsonObject.get("player_name"));
                Log.d("PlayerDataProvide", player.getPlayerName() + player.getTeamId() + player.getPlayerId());
                player.setPlayerSkill((Integer) jsonObject.get("player_skill"));
                playerList.add(player);
                Log.d("playerDta", (String) jsonObject.get("player_name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.playerList);
    }

    public PlayerDataProvider() {
    }

    protected PlayerDataProvider(Parcel in) {
        this.playerList = new ArrayList<Player>();
        in.readList(this.playerList, Player.class.getClassLoader());
    }

    public static final Parcelable.Creator<PlayerDataProvider> CREATOR = new Parcelable.Creator<PlayerDataProvider>() {
        @Override
        public PlayerDataProvider createFromParcel(Parcel source) {
            return new PlayerDataProvider(source);
        }

        @Override
        public PlayerDataProvider[] newArray(int size) {
            return new PlayerDataProvider[size];
        }
    };
}
