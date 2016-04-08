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
 * Created by Melwyn on 05/04/2016.
 */
public class TeamDataProvider implements Parcelable {
    private  List<Team> teamData = new ArrayList<>();

    public  List<Team> getTeamData() {
        return teamData;
    }

    /*static {
        Team team = null;
        String jsonArray = "[{\"team_points\":100,\"team_id\":1,\"team_name\":\"india\"},{\"team_points\":200,\"team_id\":2,\"team_name\":\"england\"}]";
        try {
            JSONArray jarray = new JSONArray(jsonArray);
            for (int i=0;i<jarray.length();i++) {
                JSONObject jsonObject = (JSONObject) jarray.get(i);
                team = new Team();
                team.setTeamId((Integer) jsonObject.get("team_id"));
                team.setTeamName((String) jsonObject.get("team_name"));
                team.setTeamPoints((Integer) jsonObject.get("team_points"));
                teamData.add(team);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/

    public  void setTeamData(JSONArray jsonArray) {
        Team team = null;
        for (int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject = null;
            try {
                jsonObject = (JSONObject) jsonArray.get(i);
                team = new Team();
                team.setTeamId((Integer) jsonObject.get("team_id"));
                team.setTeamName((String) jsonObject.get("team_name"));
                team.setTeamPoints((Integer) jsonObject.get("team_points"));
                teamData.add(team);
                Log.d("TeamDta", (String) jsonObject.get("team_name"));
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
        dest.writeTypedList(teamData);
    }

    public TeamDataProvider() {
    }

    protected TeamDataProvider(Parcel in) {
        this.teamData = in.createTypedArrayList(Team.CREATOR);
    }

    public static final Parcelable.Creator<TeamDataProvider> CREATOR = new Parcelable.Creator<TeamDataProvider>() {
        @Override
        public TeamDataProvider createFromParcel(Parcel source) {
            return new TeamDataProvider(source);
        }

        @Override
        public TeamDataProvider[] newArray(int size) {
            return new TeamDataProvider[size];
        }
    };
}
