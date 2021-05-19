/*
 * CS443, Spring 2021
 * Sergio Augusto De Sa
 *
 * This class is responsible to manage user interaction to
 * the layout where the Sudoku game is played.
 * User click in options and grid keys to play the game.
 * Class Game is where the game is generated.
 * Class Grid is where the Sudoku grid is located.
 * Class Option is where user choose values to add to the grid.
 * Control class have access to the classes above.
 */

package com.example.grid_00;

public class Control {

    private final int LIGHT_BLUE = 0xFFADD8E6;
    private final int LIGHT_GOLDEN_ROD_YELLOW = 0xFFFAFAD2;
    private final int WHITE_SMOKE = 0xFFF5F5F5;
    private Grid grid;
    private Option option;
    private Game game;
    private int current_option_position;
    private int marked_solution;

    public Control(Grid grid, Option option) {

        this.grid = grid;
        this.option = option;


        game = new Game(grid, option);
        current_option_position = 0;
        set_option_background_color();
        marked_solution = game.get_marked_solution();
    }

    /**
     * update grid buttons to display the same color
     * as the current option user choice
     */
    protected void update_option_display() {
        int option_position = option.get_option_position();

        if (option_position != current_option_position) {
            set_default_background_color();
            current_option_position = option_position;
            set_option_background_color();
        }

    }

    /**
     * update the display
     * The display is updated either by clicking at option or grid keys.
     * The click on option or grid keys will result in one of
     * the two different paths bellow:
     * 1: if user click in a button with an assigned value,
     * clicked button, and all keys with same value will change background color
     * current_option_position will update to the value of clicked button.
     * 2: if user click in an option key.
     * option key will change background color
     * all grid_key with same value of current_option_key will change background color.
     */
    protected void update_grid_display() {
        int grid_position = grid.get_grid_position();
        String current_grid_button_string = grid.get_grid_button_string_value();
        int current_grid_button_int = grid.get_grid_button_int_value();

        // the button clicked has an assigned value
        // the option and clicked button have different values
        if (current_grid_button_string.length() > 0 &&
                current_grid_button_int != current_option_position + 1) {
            option.set_option_position(grid.get_grid_button_int_value() - 1);
            current_option_position = option.get_option_position();
            set_default_background_color();
            grid.set_text(grid_position, option.get_option_string_value());
            set_option_background_color();
            update_option_background_color();
            option.set_background_color(current_option_position, LIGHT_BLUE);
            // clicked button has empty assigned value
        }  else if (current_grid_button_string.length() == 0) {
            game.set_user_solution_at(grid_position, current_option_position + 1);
            grid.set_text(grid_position, String.valueOf(current_option_position + 1));
            set_default_background_color();
            set_option_background_color();
            game.update_marked_solution();
            if(game.get_marked_solution() == 81) {
                System.out.println("Control, line 85, Game over marked is: " +
                        game.get_marked_solution());
            } else {
                System.out.println("Control, line 87; marked is: " + game.get_marked_solution());
            }
            Print_Message.message_int("Control",80, "button value: ", current_option_position);
        }

    }

    /**
     * update grid to display default background color.
     */
    private void set_default_background_color() {
        for (int i = 0; i < 81; i++) {
            grid.set_background_color(i, LIGHT_GOLDEN_ROD_YELLOW);
        }
        option.set_background_color(current_option_position, LIGHT_GOLDEN_ROD_YELLOW);
    }

    /**
     * update background color
     * of grid keys with same value of current_option key
     */
    private void set_option_background_color() {

        option.set_background_color(current_option_position, LIGHT_BLUE);
        for (int i = 0; i < 81; i++) {
            if (game.get_user_solution_at(i) == current_option_position + 1) {
                grid.set_background_color(i, LIGHT_BLUE);
            }
        }
    }

    /**
     * update background color
     * of options key to default background color and
     * current_option_position to LIGHT_BLUE
     */
    private void update_option_background_color() {
        for (int i = 0; i < 9; i++) {
            if (option.get_option_int_value(i) != current_option_position) {
                option.set_background_color(i, LIGHT_GOLDEN_ROD_YELLOW);
            } else {
                option.set_background_color((i), LIGHT_BLUE);
            }
        }
    }

    // methods to handling state of the grid

    //save current state of the game
    protected void save_handler() {
        game.add_state();
    }

    // navigate to a previous state of the game
    protected void previous_game_handler() {
        game.recover_previous_state();
        reconfigure_color_state();
    }

    // navigate to a forward state of the game
    protected void next_game_handler() {
        game.recover_next_state();
        reconfigure_color_state();
    }

    /**
     * helper method to reconfigure saved state to
     * background color of options and grid keys
     * to same color as when state was saved
     */
    private void reconfigure_color_state() {

        // get the value of current option key
        current_option_position = option.get_option_position();

        // loop options key to set to default background color
        for (int i = 0; i < 9; i++) {
            option.set_background_color(i, LIGHT_GOLDEN_ROD_YELLOW);
        }
        // set current option key to blue
        option.set_background_color(current_option_position, LIGHT_BLUE);

        // loop grid key to set background color default color
        // or blue, if is same value as current_option_position
        for (int i = 0; i < 81; i++) {
            if (grid.get_grid_button_int_value_At(i) == current_option_position + 1) {
                grid.set_background_color(i, LIGHT_BLUE);
                //grid.set_text_color(i, SEA_GREEN);
            } else {
                grid.set_background_color(i, LIGHT_GOLDEN_ROD_YELLOW);
                //grid.set_text_color(i, SEA_GREEN);
            }
        }

    }

    /**
     * loop grid keys and compare current assigned value,
     * to solution value, if they are different,
     * then change background and text color
     */
    protected void hint_handler() {
        for (int i = 0; i < 81; i++) {
            if (game.get_user_solution_at(i) != 0 &&
                    game.get_user_solution_at(i) !=
                            game.get_sudoku_solution_at(i)) {

                grid.set_background_color(i, WHITE_SMOKE);
                //grid.set_text_color(i, CRIMSON);
            }
        }
    }

    // call game class to handle previous play button click
    protected void previous_play_handler() {
        game.remove_previous();
    }

    // call game class to handle delete button click
    protected void delete_handler(int index) {
        game.delete_user_solution(index);
    }

    /**
     * to get the number of solutions already  filled in
     * the main Sudoku grid.
     * @return marked_solution
     */
    protected int get_marked_solution(){
        marked_solution = game.get_marked_solution();
        return marked_solution;
    }

    /**
     * to return the number of mistakes found in
     * the main Sudoku grid.
     * @return number of wrong keys
     */
    protected int get_mistakes() {
        return game.calculate_mistakes();
    }

    /**
     * to find the solution to an index in
     * the main Sudoku grid.
     * @param index
     * @return solution
     */
    protected int get_solution_at(int index) {
        return game.get_sudoku_solution_at(index);
    }
}
