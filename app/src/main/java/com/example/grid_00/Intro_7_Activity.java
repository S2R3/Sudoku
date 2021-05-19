package com.example.grid_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro_7_Activity extends AppCompatActivity {

    Button return_back;
    Button play;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_7);

        play = (Button) findViewById(R.id.intro_7_play);
        return_back = (Button) findViewById(R.id.intro_7_return);
        next = (Button) findViewById(R.id.intro_7_next);

        return_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_return(view);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_play(view);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_next(view);
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

    public void start_return(View v) {
        Intent intent = new Intent(this, Intro_6_Activity.class);
        startActivity(intent);
    }

    public void start_play(View v) {
        Intent intent = new Intent(this, Grid_Activity.class);
        startActivity(intent);
    }

    public void start_next(View v) {
        Intent intent = new Intent(this, Intro_8_Activity.class);
        startActivity(intent);
    }
}