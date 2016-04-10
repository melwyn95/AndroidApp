package com.example.dsouza.test;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DetailActivity extends Activity {
    
	Textview detail_name;
	Textview detail_team;
	Textview detail_skill;
	Textview detail_matches;
	Textview detail_matches_val;
	Textview detail_runs;
	Textview detail_runs_val;
	Textview detail_average;
	Textview detail_average_val;
	Textview detail_best;
	Textview detail_best_val;
	Textview detail_sr;
	Textview detail_sr_val;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);			
		
        setContentView(R.layout.activity_details);
        
		
		Bundle bundle = getIntent().getExtras();
		
		
		
		
		// get VIEWs
		detail_name = (Textview)findViewById(R.id.detail_name);
		
		detail_team = (Textview)findViewById(R.id.detail_team);
		
		detail_skill = (Textview)findViewById(R.id.detail_skill);
		
		detail_matches = (Textview)findViewById(R.id.detail_matches);
		detail_matches_val = (Textview)findViewById(R.id.detail_matches_val);
		
		detail_runs = (Textview)findViewById(R.id.detail_runs);
		detail_runs_val = (Textview)findViewById(R.id.detail_runs_val);
		
		detail_average = (Textview)findViewById(R.id.detail_average);
		detail_average_val = (Textview)findViewById(R.id.detail_average_val);
		
		detail_best = (Textview)findViewById(R.id.detail_best);
		detail_best_val = (Textview)findViewById(R.id.detail_best_val);
		
		detail_sr = (Textview)findViewById(R.id.detail_sr);
		detail_sr_val = (Textview)findViewById(R.id.detail_sr_val);
		
		//detail_name.setText("");
		//detail_team.setText("");
		//detail_skill.setText("");
		//detail_matches.setText("");
		//detail_matches_val.setText("");
		//detail_runs.setText("");
		//detail_runs_val.setText("");
		//detail_average.setText("");
		//detail_average_val.setText("");
		//detail_best.setText("");
		//detail_best_val.setText("");
		//detail_sr.setText("");
		//detail_sr_val.setText("");
		
    }
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_groupwise, menu);
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
