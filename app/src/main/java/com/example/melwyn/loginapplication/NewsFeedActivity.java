package com.example.dsouza.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class NewsFeedActivity extends Activity {
    public static final String TAG="NEWS_FEED_ACTIVITY";
	
	//views
	private Textview textview;
    private Button button;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsFeed);
		
		
        
    }

	
	public void viewScorecard(View view) {
		
		Log.d(TAG, "viewScorecard clicked");
		Intent intent = new Intent(this, ScorecardActivity.class); 		
		
		textview = (Textview)findViewById(R.id.team_1_txt);
		intent.putExtra("team_1_txt",textview.getText());
		
		textview = (Textview)findViewById(R.id.team_2_txt);
		intent.putExtra("team_2_txt",textview.getText());
						
		startActivity(intent);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
