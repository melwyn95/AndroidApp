package com.example.melwyn.loginapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Log.d("HomeActivity", "Before execute");

        TeamDetails td= new TeamDetails();

        td.execute();

        teamData = teamDataProvider.getTeamData();

        ArrayAdapter<Team> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teamData);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String teamName = (String) ((TextView)view).getText();
                Log.d("Team Name", teamName);
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

    /*public void logoutClickHandler(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }*/

    class TeamDetails extends AsyncTask<String, String, String> {

        String url = "http://jbossews-melwyn95.rhcloud.com/TeamsServlet";

        @Override
        protected String doInBackground(String... params) {
            JSONParser jsonParser  = new JSONParser();
            jsonArray = jsonParser.getJsonArray(url, "GET");
            teamDataProvider.setTeamData(jsonArray);
            return null;
        }
    }
}
