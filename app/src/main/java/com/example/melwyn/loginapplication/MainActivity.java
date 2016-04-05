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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText userName = null, password = null;
    Button submit, register;
    JSONParser jsonParser = new JSONParser();
    JSONObject json;
    String url = "http://jbossews-melwyn95.rhcloud.com/LoginServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Login().execute();
                //Toast.makeText(MainActivity.this, "Login Failed. Try Again", Toast.LENGTH_LONG).show();
            }
        });

        register = (Button) findViewById(R.id.button3);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Register().execute();
                Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_LONG).show();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String[] getStrings() {
        String user_name = userName.getText().toString();
        String pass_word = password.getText().toString();
        String[] ret = new String[2];
        ret[0] = user_name;
        ret[1] = pass_word;
        return ret;
    }

    class Login extends AsyncTask<String, String, String> {

        String url = "http://jbossews-melwyn95.rhcloud.com/LoginServlet";

        @Override
        protected String doInBackground(String... params) {
            String[] parameters = getStrings();
            List<NameValuePair> param = new ArrayList<>();
            param.add(new BasicNameValuePair("u", parameters[0]));
            param.add(new BasicNameValuePair("p", parameters[1]));
            json = jsonParser.makeHTTPRequest(url, "GET", param);
            String s = null;
            try {
                s= json.getString("info");
                Log.d("Msg", json.getString("info"));
                if(s.equals("success")){
                    Intent login = new Intent(getApplicationContext(), HomeActivity.class);
                    login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(login);
                    finish();
                } else {
                    Log.d("MainActivity", "Login Failed");
                    return "fail";
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    class Register extends AsyncTask<String, String, String> {

        String url = "http://jbossews-melwyn95.rhcloud.com/RegisterServlet";

        @Override
        protected String doInBackground(String... params) {
            String[] parameters = getStrings();
            List<NameValuePair> param = new ArrayList<>();
            param.add(new BasicNameValuePair("u", parameters[0]));
            param.add(new BasicNameValuePair("p", parameters[1]));
            json = jsonParser.makeHTTPRequest(url, "GET", param);
            String s = null;
            try {
                s= json.getString("info");
                Log.d("Msg", json.getString("info"));
                if(s.equals("success")){
                    Log.d("MainActivity", "Register Success");
                } else {
                    Log.d("MainActivity", "Register Failed");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
