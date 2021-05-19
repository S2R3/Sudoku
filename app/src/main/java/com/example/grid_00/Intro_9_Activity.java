/*
 * CS 443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * the purpose of this class is to handle the user
 * "How To Play" option
 * There are only choices choices user can choose from here.
 */

package com.example.grid_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro_9_Activity extends AppCompatActivity {

    // to return to the previous menu
    Button return_back;
    // to play Sudoku game
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_9);

        play = (Button) findViewById(R.id.intro_9_play);
        return_back = (Button) findViewById(R.id.intro_9_return);

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
        Intent intent = new Intent(this, Intro_8_Activity.class);
        startActivity(intent);
    }

    public void start_play(View v) {
        Intent intent = new Intent(this, Grid_Activity.class);
        startActivity(intent);
    }
}