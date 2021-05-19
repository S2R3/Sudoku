/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class Grid_Activity
 *
 * THe purpose of this class is to have reference to buttons
 * that are available to user play the Sudoku game
**/

package com.example.grid_00;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.util.Log;
import android.widget.TextView;

public class Grid_Activity extends Activity {

    // the 81 buttons that solve the sudoku game
    private Grid grid;
    // the 9 buttons that are used to assign value to grid buttons
    private Option option;
    // the value to display the countdown timer
    private TextView game_timer;
    // to track time interval change
    private int update_timer;
    // to enable the option to delete a value
    private boolean delete_button_value = false;
    Log v;
    // to track the grid last user input
    //private int stop;
    private boolean stop = false;

    // to track the time user takes to solve the Sudoku game
    private CountDownTimer timer;
    private long millisInFuture = 50000000;
    private long countDownInterval = 1000;

    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

        game_timer = (TextView) findViewById(R.id.game_couter);


        timer = new CountDownTimer(millisInFuture, countDownInterval) {

            @Override
            public void onTick(long millisUntilFinished) {

                game_timer.setText(String.valueOf(update_timer));
                update_timer++;
                //int stop = control.get_marked_solution();
            }

            @Override
            public void onFinish() {
                timer.cancel();
                millisInFuture = 0;
            }
        }.start();


        grid = new Grid();
        option = new Option();
        set_option_buttons();
        set_grid_buttons();
        set_helpers_button();

        control = new Control(grid, option);
    }


    /**
     * the listener to trigger in case user click
     * on any of the grid 81 grid buttons.
     * If the boolean delete_button_value is true,
     * the button is enable to delete button grid values
     * if the button is false, the listener will pass
     * the button index to grid, from there grid
     * will update button accordingly.
     */
    private void grid_listener() {
        for (int i = 0; i < 81; i++) {
            int index = i;
            grid.get_button(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (delete_button_value) {
                        handler_delete(index);
                    } else {
                        grid.set_grid_position(index);
                        control.update_grid_display();

                        //stop = control.get_marked_solution();
                        stop = control.get_marked_solution();
                        if (stop) {
                        //if (stop == 81) {
                            control.print_array_user_solution();
                            end_sudoku();
                        }
                    }
                }
            });
        }
    }

    /**
     * this function is responsible to update the grid_layout
     * after the user make the final choice to fill the grid.
     */
    public void end_sudoku() {
        LinearLayout linearLayout_parent =
                (LinearLayout) findViewById(R.id.parent_layout);
        LinearLayout linearLayout_image_butons =
                (LinearLayout) findViewById(R.id.image_buttons);
        LinearLayout linearLayout_row_op =
                (LinearLayout) findViewById(R.id.row_op);
        LinearLayout linearLayout_bottom =
                (LinearLayout) findViewById(R.id.linear_layout_boton);
        ImageButton imageButton_hint =
                (ImageButton) findViewById(R.id.hint);
        ImageButton imageButton_previous_play =
                (ImageButton) findViewById(R.id.previous_play);
        Button button_remove = (Button) findViewById(R.id.remove);
        TextView game_info = (TextView) findViewById(R.id.game_info);
        TextView current_game = (TextView) findViewById(R.id.current_game);
        TextView option = (TextView) findViewById(R.id.options);

        linearLayout_parent.removeView(linearLayout_image_butons);
        linearLayout_parent.removeView(linearLayout_row_op);

        linearLayout_bottom.removeView(imageButton_hint);
        linearLayout_bottom.removeView(imageButton_previous_play);
        linearLayout_bottom.removeView(button_remove);

        game_info.setText("Mistakes");
        current_game.setText(String.valueOf(control.get_mistakes()));
        option.setText("GAME OVER");
        // to handler the user mistakes
        find_mistakes();
        // to stop countdown timer
        timer.onFinish();
    }

    /**
     * this function is responsible to change text color of
     * wrong user input to red
     */
    private void find_mistakes() {
        Button check_value;
        int button_value;
        for (int i = 0; i < 81; i++) {
            check_value = grid.get_button(i);
            button_value = grid.get_grid_button_int_value_At(i);
            if (button_value != control.get_solution_at(i)) {
                check_value.setTextColor(Color.RED);
            }
        }
    }

    /**
     * the listener to trig when user click in
     * any of the 9 option buttons
     */
    private void option_listener() {

        for (int i = 0 ; i < 9; i++) {
            int index = i;
            option.get_button(i).setOnClickListener(v -> {
                option.set_option_position(index);
                control.update_option_display();
            });
        }
    }

    /**
     * create a list of 9 buttons called option
     * the option buttons display 9 buttons
     * users have a choice from 1 to 9
     * the choice button assign values to the grid buttons
     */
    private void set_option_buttons() {

        LinearLayout l = findViewById(R.id.row_op);

        for (int i = 0; i < l.getChildCount(); i++) {
            option.add_button(i, (Button) l.getChildAt(i));
        }

        option_listener();
    }


    /**
     * there are 81 grid buttons
     * users will fill values from 1 to 9 in each of
     * the buttons that have not assigned a value
     */
    private void set_grid_buttons() {
        LinearLayout l;

        l = findViewById(R.id.row0);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row1);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 9, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row2);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 18, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row3);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 27, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row4);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i  + 36, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row5);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 45, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row6);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 54, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row7);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 63, (Button) l.getChildAt(i));
        }
        l = findViewById(R.id.row8);
        for (int i = 0; i < l.getChildCount(); i++) {
            grid.add_button(i + 72, (Button) l.getChildAt(i));
        }
        grid_listener();
    }

    /**
     * helper buttons are buttons used to give users tools
     * to manipulate the game
     */
    protected void set_helpers_button() {

        // save the state of the game
        ImageButton save = (ImageButton) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.save_handler();
            }
        });

        // navigate to a previous saved state
        ImageButton previous_game = (ImageButton) findViewById(R.id.previous_game);
        previous_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.previous_game_handler();
            }
        });

        // navigate to a forward state
        ImageButton next_game = (ImageButton) findViewById(R.id.next_game);
        next_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.next_game_handler();
            }
        });

        // change button background color to red if user
        // assign a wrong value.
        ImageButton hint = (ImageButton) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.hint_handler();
            }
        });

        // delete_button_value the previous user choice of value to a button
        ImageButton previous_play = (ImageButton) findViewById(R.id.previous_play);
        previous_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.previous_play_handler();
            }
        });

        /*
         * the first click update boolean delete_button_value to true,
         * the second click update boolean delete_button_value to false
         * any click to grid button while boolean delete_button_value is true
         * will delete_button_value the assigned value to the button clicked
         */
        Button delete_button = (Button) findViewById(R.id.remove);
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Grid_Activity.this.delete_button_value) {
                    Grid_Activity.this.delete_button_value = false;
                    delete_button.setBackgroundColor(Color.parseColor("#ADD8E6"));
                } else {
                    Grid_Activity.this.delete_button_value = true;
                    delete_button.setBackgroundColor(Color.parseColor("#DC143C"));
                }
            }
        });

        // display the value of current state, starting at 1.
        TextView current_game = (TextView) findViewById(R.id.current_game);
        grid.add_current_game(current_game);
    }

    /**
     * the index of button user click wants to delete
     * @param index the index of the clicked button
     */
    private void handler_delete(int index) {
        //stop--;
        control.delete_handler(index);
    }

}