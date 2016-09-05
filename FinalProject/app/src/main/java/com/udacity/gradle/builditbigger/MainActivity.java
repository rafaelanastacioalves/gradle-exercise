package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jokeshow.JokeActivity;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.EndpointsAsyncTaskCallBack;
import com.udacity.gradle.builditbigger.R;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTaskCallBack {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    protected void onResume() {
        spinner.setVisibility(View.GONE);
        super.onResume();


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

    public void tellJoke(@SuppressWarnings("UnusedParameters") View view) {

        spinner.setVisibility(View.VISIBLE);

        new EndpointsAsyncTask(this).execute();

    }


    @Override
    public void onTaskSuccess(String result) {
        Intent i = new Intent(this, JokeActivity.class);
        i.putExtra(JokeActivity.JOKE_EXTRA, result);
        startActivity(i);
    }
}
