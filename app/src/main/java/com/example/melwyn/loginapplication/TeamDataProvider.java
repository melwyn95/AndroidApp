package com.example.melwyn.loginapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melwyn on 05/04/2016.
 */
public class TeamDataProvider {
    private static List<Team> teamData = new ArrayList<>();

    public static List<Team> getTeamData() {
        return teamData;
    }

    static {
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

    }
}
