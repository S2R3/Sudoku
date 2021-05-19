/*
 * CS 443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * the purpose of this class is to handle the user
 * "How To Play" option
 * There are only three choices user can choose from here.
 */

package com.example.grid_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro_4_Activity extends AppCompatActivity {

    // to play the Sudoku Game
    Button play;
    // to return to previous menu
    Button return_back;
    // to display the next "How to Play" option
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_4);

        play = (Button) findViewById(R.id.intro_4_play);
        return_back = (Button) findViewById(R.id.intro_4_return);
        next = (Button) findViewById(R.id.intro_4_next);

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
        Intent intent = new Intent(this, Intro_3_Activity.class);
        startActivity(intent);
    }

    public void start_play(View v) {
        Intent intent = new Intent(this, Grid_Activity.class);
        startActivity(intent);
    }

    public void start_next(View v) {
        Intent intent = new Intent(this, Intro_5_Activity.class);
        startActivity(intent);
    }
}