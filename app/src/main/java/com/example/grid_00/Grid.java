/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class Grid
 *
 * The purpose of this class is save the Buttons available
 * to users complete the Sudoku game.
 * There are a total of 81 Buttons.
 * At start state, some Buttons choose randomly
 * will have the Sudoku solution assigned value,
 * users are not permitted to change their value
 * the rest of Buttons user are free to assign value, and change as desired.
 **/

package com.example.grid_00;

import android.widget.Button;
import android.widget.TextView;


public class Grid {

    // the array to save grid buttons
    private Button[] grid;
    // the position of current user choice
    private int grid_position;
    // the text to display current state of the game
    private TextView current_game;

    public Grid() {

        grid = new Button[81];
        grid_position = -1;
    }

    /**
     * to add a new button to grid[]
     * @param index the index to add a new button
     * @param button the button to add
     */
    protected void add_button(int index, Button button) {
        grid[index] = button;
    }

    /**
     * to return a button saved in grid[]
     * @param index the index of the button in grid[]
     * @return the button to return
     */
    protected Button get_button(int index) {
        return grid[index];
    }

    /**
     * to update the text button display to users view
     * @param index the grid[] index of the button
     * @param text the new String text to display
     */
    protected void set_text(int index, String text) {
        grid[index].setText(text);
    }

    /**
     * to update button background color
     * @param index the grid[] index of the button
     * @param color the color to update background
     */
    protected void set_background_color(int index, int color) {

        Button button = grid[index];
        button.setBackgroundColor(color);
    }

    /**
     * to update button text color
     * @param index the grid[] index of the button
     * @param color the color to update text
     */
    protected void set_text_color(int index, int color) {
        Button button = grid[index];
        button.setTextColor(color);
    }

    /**
     * to update grid[] position
     * @param new_position the position to update grid[] position
     */
    protected void set_grid_position(int new_position) {
        grid_position = new_position;
    }

    /**
     * to give the current grid[] position
     * @return the current position
     */
    protected int get_grid_position() {
        return grid_position;
    }

    /**
     * find the current Button CharSequence value
     * cast the value to String
     * if String length is bigger than 0
     * it converts the String to an equivalent int value
     * else it set the value in int to -1
     * @return int
     */
    protected int get_grid_button_int_value() {
        Button button = (Button) grid[grid_position];
        int button_int_value;
        String string_value = button.getText().toString();
        if (string_value.length() > 0) {
            button_int_value = Integer.parseInt(string_value);
        } else {
            button_int_value = -1;
        }
        return  button_int_value;
    }

    /**
     * the value button display to users
     * @param index the grid[] button location
     * @return the int value of button at grid[index]
     */
    protected int get_grid_button_int_value_At(int index) {
        Button button = (Button) grid[index];
        String string_value = button.getText().toString();
        if (string_value.length() == 0) {
            return  0;
        } else {
            return Integer.parseInt(string_value);
        }
    }

    /**
     * the String value button display to user
     * at current grid[grid_position]
     * @return the String value of button
     */
    protected String get_grid_button_string_value() {
        Button button = (Button) grid[grid_position];
        String string_value = button.getText().toString();
        return string_value;
    }

    /**
     * Add TextView that holds the current_state count
     * to Grid class, in case it need updates
     * @param current_state the state to display to user view
     */
    protected void add_current_game(TextView current_state) {
        this.current_game = current_state;
    }


    /**
     * Display the current_state number
     * @param game_number the number of the game to display
     */
    protected  void update_current_game(int game_number) {
        current_game.setText(String.valueOf(game_number + 1));
    }

}
