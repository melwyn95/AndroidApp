package com.example.melwyn.loginapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayerDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String playerName = getIntent().getStringExtra("playerName");
        String imageName = getIntent().getStringExtra("imageName");
        String playerType = getIntent().getStringExtra("playerType");
        if (playerType.equals("Batsman")) {
            Batsman b = getIntent().getParcelableExtra("batsman");
            String playerDetails = "Player Name    :    " + playerName + "\nPlayer Matches    :    " + b.getPlayerMatches() + "\nPlayer Runs    :    " + b.getPlayerRuns() + "\nPlayer Stumpings    :    " + b.getPlayerStumping() + "\nPlayer Best    :    " + b.getPlayerBest() + "\nPlayer Average    :    " + b.getPlayerAvg() + "\nPlayer Strike-Rate    :    " + b.getPlayerSr() + "\nPlayer Catches    :    " + b.getPlayerCatches();
            ImageView iv = (ImageView) findViewById(R.id.imageView2);
            int imageResourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            iv.setImageResource(imageResourceId);
            ViewGroup.LayoutParams params = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
            );
            LinearLayout ll = (LinearLayout) findViewById(R.id.playerDetailsList);
            TextView tv = new TextView(this);
            tv.setText(playerDetails);
            tv.setLayoutParams(params);
            ll.addView(tv);
            Log.d("Player Details", String.valueOf(b.getPlayerAvg()));
        } else {
            Bowler b = getIntent().getParcelableExtra("bowler");
            String playerDetails = "Player Name    :    " + playerName + "\nPlayer Matches    :    " + b.getPlayerMatches() + "\nPlayer Runs    :    " + b.getPlayerRuns() + "\nPlayer Overs    :    " + b.getPlayerOvers() + "\nPlayer Best    :    " + b.getPlayerBest() + "\nPlayer Average    :    " + b.getPlayerAvg() + "\nPlayer Wickets    :    " + b.getPlayerWickets() + "\nPlayer Maidens    :    " + b.getPlayerMaidens();
            ImageView iv = (ImageView) findViewById(R.id.imageView2);
            int imageResourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            iv.setImageResource(imageResourceId);
            ViewGroup.LayoutParams params = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
            );
            LinearLayout ll = (LinearLayout) findViewById(R.id.playerDetailsList);
            TextView tv = new TextView(this);
            tv.setText(playerDetails);
            tv.setLayoutParams(params);
            ll.addView(tv);
            Log.d("Player Details", String.valueOf(b.getPlayerAvg()));
        }
        Log.d("Player Details", playerName);
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
}
