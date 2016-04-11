package com.example.melwyn.loginapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.List;

public class TeamDetailsActivity extends AppCompatActivity {

    JSONArray jsonArray = null;
    List<Player> playerData = null;
    PlayerDataProvider playerDataProvider = new PlayerDataProvider();
    int teamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_team_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TeamDataProvider teamDataProvider = getIntent().getParcelableExtra("teamData");

        Log.d("TeamDetailsActivity", teamDataProvider.getTeamData().get(0).getTeamName());

        final List<Team> teamData = teamDataProvider.getTeamData();

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teamData);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String teamName = (String) ((TextView) view).getText();
                Log.d("Team Name", teamName);
                Team team = teamData.get(position);
                teamId = team.getTeamId();
                new Players().execute();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class Players extends AsyncTask<String, String, String> {

        String url = "http://jbossews-melwyn95.rhcloud.com/PlayersServlet?teamId="+teamId;

        @Override
        protected String doInBackground(String... params) {
            JSONParser jsonParser  = new JSONParser();
            jsonArray = jsonParser.getJsonArray(url, "GET");
            playerDataProvider.setPlayerList(jsonArray);
            Log.d("Team Details Activity", "Inside Async Task got the teams from server");
            Intent teamsData = new Intent(getApplicationContext(), GridViewActivity.class);
            Log.d("Team Details Activity", playerDataProvider.getPlayerList().get(0).getPlayerName());
            teamsData.putExtra("playerData", playerDataProvider);
            teamsData.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(teamsData);
            finish();
            return null;
        }
    }

}
