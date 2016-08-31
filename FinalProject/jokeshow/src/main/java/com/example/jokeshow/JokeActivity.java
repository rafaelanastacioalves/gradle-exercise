package com.example.jokeshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_EXTRA = "JOKE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        if (getIntent().getExtras().containsKey(JOKE_EXTRA)){
            String result = getIntent().getStringExtra(JOKE_EXTRA);
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        }
    }
}
