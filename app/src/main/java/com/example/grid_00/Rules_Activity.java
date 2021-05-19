package com.example.grid_00;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Rules_Activity extends Activity {

    Button play;
    Button return_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rules_layout);

        play = (Button) findViewById(R.id.rules_play);
        return_main = (Button) findViewById(R.id.rules_return);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_play(view);
            }
        });

        return_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_return(view);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void start_play(View v) {
        Intent intent = new Intent(this, Grid_Activity.class);
        startActivity(intent);
    }

    public void start_return(View v) {
        Intent intent = new Intent(this, Intro_1_Activity.class);
        startActivity(intent);
    }
}