package com.example.melwyn.loginapplication;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridview = (GridView) findViewById(R.id.gridview);

        PlayerDataProvider playerDataProvider = getIntent().getParcelableExtra("playerData");
        final List<Player> playerList = playerDataProvider.getPlayerList();

        CustomAdapter customAdapter = new CustomAdapter(GridViewActivity.this, playerList);

        gridview.setAdapter(customAdapter);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, playerList.get(position).getPlayerName(), Toast.LENGTH_LONG).show();
                //Intent i = new Intent(getApplicationContext(), PlayerDetails.class);
                String imageName = "";
                String[] playerName =playerList.get(position).getPlayerName().split(" ");
                imageName = playerName[0]+"_"+playerName[1];
                if (playerList.get(position).getPlayerSkill() == 1) {
                    //Batsman b = new Batsman();
                    String url = "http://jbossews-melwyn95.rhcloud.com/DetailsServlet?skillId=1&playerId="+playerList.get(position).getPlayerId();
                    /*JSONParser jsonParser = new JSONParser();
                    JSONArray jsonArray = jsonParser.getJsonArray(url, "GET");
                    try {
                        b.setBatsman((JSONObject) jsonArray.get(0));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    i.putExtra("batsman", b);
                    i.putExtra("playerName", playerList.get(position).getPlayerName());
                    startActivity(i);*/
                    new GetBatsman(url, playerList.get(position).getPlayerName(), imageName).execute();
                } else {
                    String url = "http://jbossews-melwyn95.rhcloud.com/DetailsServlet?skillId=2&playerId="+playerList.get(position).getPlayerId();

                    new GetBowler(url, playerList.get(position).getPlayerName(), imageName).execute();
                }

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

    class GetBatsman extends AsyncTask<String, String, String> {

        String url;
        String playerName;
        String imageName;

        public GetBatsman(String url, String playerName, String imageName) {
            this.url = url;
            this.playerName = playerName;
            this.imageName = imageName;
        }

        @Override
        protected String doInBackground(String... params) {
            Intent i = new Intent(getApplicationContext(), PlayerDetails.class);
            Batsman b = new Batsman();
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = jsonParser.getJsonArray(url, "GET");
            try {
                b.setBatsman((JSONObject) jsonArray.get(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            i.putExtra("batsman", b);
            i.putExtra("playerName", playerName);
            i.putExtra("imageName", imageName);
            i.putExtra("playerType", "Batsman");
            startActivity(i);
            return null;
        }
    }

    class GetBowler extends AsyncTask<String, String, String> {

        String url;
        String playerName;
        String imageName;

        public GetBowler(String url, String playerName, String imageName) {
            this.url = url;
            this.playerName = playerName;
            this.imageName = imageName;
        }

        @Override
        protected String doInBackground(String... params) {
            Intent i = new Intent(getApplicationContext(), PlayerDetails.class);
            Bowler b = new Bowler();
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = jsonParser.getJsonArray(url, "GET");
            try {
                b.setBowler((JSONObject) jsonArray.get(0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            i.putExtra("bowler", b);
            i.putExtra("playerName", playerName);
            i.putExtra("imageName", imageName);
            i.putExtra("playerType", "Bowler");
            startActivity(i);
            return null;
        }
    }
}
