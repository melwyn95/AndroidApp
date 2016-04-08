package com.example.melwyn.loginapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class TeamDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_team_details_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TeamDataProvider teamDataProvider = getIntent().getParcelableExtra("teamData");

        Log.d("TeamDetailsActivity", teamDataProvider.getTeamData().get(0).getTeamName());

        List<Team> teamData = teamDataProvider.getTeamData();

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, teamData);

        ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String teamName = (String) ((TextView) view).getText();
                Log.d("Team Name", teamName);
            }
        });

    }

}
