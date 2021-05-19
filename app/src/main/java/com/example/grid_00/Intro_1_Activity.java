/*
 * CS 443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * the purpose of this class is to handle the first layout
 * user will see it.
 * There are only three choices user can choose from.
 */

package com.example.grid_00;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro_1_Activity extends AppCompatActivity {

    // to change to rules layout
    Button rules;
    // to change to How To Play layout
    Button how_to_play;
    // to play the Sudoku game
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_1);

        rules = (Button) findViewById(R.id.intro_rules);
        how_to_play = (Button) findViewById(R.id.intro_how_to_play);
        play = (Button) findViewById(R.id.intro_play);

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_rules(view);
            }
        });

        how_to_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start_how_to_play(view);
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

    public void start_rules(View v) {
        Intent intent = new Intent(this, Rules_Activity.class);
        startActivity(intent);
    }

    public void start_how_to_play(View v) {
        Intent intent = new Intent(this, Intro_2_Activity.class);
        startActivity(intent);
    }

    public void start_play(View v) {
        Intent intent = new Intent(this, Grid_Activity.class);
        startActivity(intent);
    }
}