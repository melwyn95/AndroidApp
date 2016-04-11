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

import org.json.JSONArray;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    JSONArray jsonArray = null;
    List<Team> teamData = null;
    TeamDataProvider teamDataProvider = new TeamDataProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    public void squadOnClickHandler(View view) {
        new TeamDetails().execute();

    }
    
    public void viewNewsfeed(View view) {
        
        Intent intent= new Intent(this, NewsFeedActivity.class); 
        startActivity(intent);

    }

    class TeamDetails extends AsyncTask<String, String, String> {

        String url = "http://jbossews-melwyn95.rhcloud.com/TeamsServlet";

        @Override
        protected String doInBackground(String... params) {
            JSONParser jsonParser  = new JSONParser();
            jsonArray = jsonParser.getJsonArray(url, "GET");
            teamDataProvider.setTeamData(jsonArray);
            Log.d("Home Activity", "Inside Async Task got the teams from server");
            Intent teamsData = new Intent(getApplicationContext(), TeamDetailsActivity.class);
            Log.d("Home Activity", teamDataProvider.getTeamData().get(0).getTeamName());
            teamsData.putExtra("teamData", teamDataProvider);
            teamsData.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(teamsData);
            finish();
            return null;
        }
    }
}
