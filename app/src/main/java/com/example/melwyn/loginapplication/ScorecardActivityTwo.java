package com.example.dsouza.test;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ScorecardActivityTwo extends Activity {
    
	private ListView listview;
    private ArrayAdapter<String> adapter;
    String[] groups=new String[]{"One","One","One","One"
            ,"One","One","One","One","One","One","One"};
			
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);			
		
        setContentView(R.layout.activity_scorecard_dynamic_two);
        
		
		Bundle bundle = getIntent().getExtras();
		
		String teamOne,teamTwo;
		
		
		if(bundle != null){
			
				// get team names
			teamOne=bundle.getString("team_1_txt");
			teamTwo=bundle.getString("team_2_txt");
			
				// do db data-fetch
			
				// get List
			
			//listview=(ListView)findViewById(R.id.list_groupwise);
			//adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,groups);
			//listview.setAdapter(adapter);
			
			
		}
		
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
