/*
 * CS443, Spring 2021
 * Sergio Augusto De Sa
 *
 * The purpose of this class is to hold the solution to
 * the game and the user input.
 * In the event a user chooses to save the state of the game,
 * this class instantiate a new instance of State class to
 * save the current state into an ArrayList.
 * In the event a user choose to recover a previous saved state,
 * this class recover the state of choice from the ArrayList.
 */

package com.example.grid_00;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Game {

    private Grid grid;
    private Option option;
    private Sudoku sudoku;
    private State state;

    Random random;

    // to save the game solution
    private final int[] SUDOKU_SOLUTION;
    // to save the initial solution give to user
    private final int[] INITIAL_SOLUTION;
    // to save the user inputs to the game
    private int[] user_solution;
    // to track the number of cells are assigned in the Sudoku grid
    private int marked_grid_counting;
    // to track the number of states are saved
    private int state_number;
    // to display the state the user is playing
    private int current_state;
    // the current cell in Sudoku grid
    private int position;
    // the current choice in option keys
    private int option_position;
    // to save states of the game
    private ArrayList<State> arrayList_state;
    // to place users choice to Sudoku grid in sequence
    private Stack<Integer> stack_solution;

    private final int LIGHT_BLUE = 0xFFADD8E6;
    private final int LIGHT_GOLDEN_ROD_YELLOW = 0xFFFAFAD2;

    public Game(Grid grid, Option option) {

        this.grid = grid;
        this.option = option;
        // instantiate a new instance of Sudoku
        sudoku = new Sudoku();
        position = grid.get_grid_position();
        option_position = option.get_option_position();

        // hold the solution of the game
        SUDOKU_SOLUTION = new int[81];
        // the initial solution of the game
        INITIAL_SOLUTION = new int[81];
        // hold the initial state, and any user additional choice
        user_solution = new int[81];
        // the number of buttons already filled with values
        marked_grid_counting = 42;
        // the number of states of the game
        state_number = -1;
        // the current sate of the game
        current_state = -1;
        // used to save states of the game
        arrayList_state = new ArrayList<>();
        // used to hold users choice of grid keys
        stack_solution = new Stack<>();

        // to fill SUDOKU_SOLUTION with valid solution
        fill_solution();
        // to partially fill user_solution
        fill_initial_user_solution();
        // fill INITIAL_SOLUTION
        fill_initial_solution();
        // to save the initial state of the game
        add_state();
    }

    /**
     * given a grid position,
     * it returns the option user choice from 1 to 9
     * @param position the grid position from 0 to 80
     * @return the position choice value from 0 to 8
     */
    protected int get_user_solution_at(int position) {
        return user_solution[position];
    }

    /**
     * Populate user_solution[],
     * the array used to hold the inputs users choose to fill the grid.
     *    The position refers to the position from 0 to 80 in the grid
     *    The value refers to users option choice from 0 to 8
     * @param position of the grid
     * @param value choice to fill the grid
     */
    protected void set_user_solution_at(int position, int value) {
        user_solution[position] = value;
        stack_solution.push(position);
        if(option.get_option_position() + 1 == value) {
            grid.set_background_color(position, LIGHT_BLUE);
        } else {
            grid.set_background_color(position, LIGHT_GOLDEN_ROD_YELLOW);
        }
        //Print_Array.print_stack(stack_solution);
    }

    /**
     * delete the assign button grid value assigned by user,
     * it will refuse to delete the values give to user
     * at beginning of game.
     * @param position the grid index to delete
     */
    protected void delete_user_solution(int position) {
        if (INITIAL_SOLUTION[position] == 0) {
            user_solution[position] = 0;
            grid.set_text(position, "");
            grid.set_background_color(position, LIGHT_GOLDEN_ROD_YELLOW);
            //remove(Object o) remove the object at index o
            stack_solution.remove((Integer) position);
        }else {
            System.out.println("Game, line 115 Operation not possible");
        }
    }

    /**
     * return value of SUDOKU_SOLUTION at position
     * @param position the index to look for
     * @return the value at position
     */
    protected int get_sudoku_solution_at(int position) {
        return SUDOKU_SOLUTION[position];
    }

    /**
     * fill the array SUDOKU_SOLUTION with valid values.
     * The array will hold the solution of the game
     */
    private void fill_solution() {
        for (int position = 0; position < SUDOKU_SOLUTION.length; position++) {
            SUDOKU_SOLUTION[position] = sudoku.get_sudoku(position);
        }
    }

    /**
     * choose random keys of initial_solution array
     * and copy the value of the same index from SUDOKU_SOLUTION,
     * the other index are assign to zero.
     */
    protected void fill_initial_user_solution() {

        /*
         * initial_solution initially has the same length of
         * SUDOKU_SOLUTION, and it is assign values from 0 to 80
         */
        ArrayList<Integer> initial_solution = new ArrayList<>();
        int length = SUDOKU_SOLUTION.length;

        for (int i = 0; i < SUDOKU_SOLUTION.length; i++) {
            initial_solution.add(i);
        }

        random = new Random();

        /*
         * random_number draw a number from 0 to 80,
         * and decrease the range by one at each loop iteration
         * the random_number draw the index ot initial_solution ArrayList,
         * the value in initial_solution index map
         * SUDOKU_SOLUTION index, and get the value of that index.
         * THe value of SUDOKU_SOLUTION is copied to user_solution
         */
        for (int i = 0; i < 42; i++) {
            int random_number = random.nextInt(length);
            user_solution[initial_solution.get(random_number)] =
                    SUDOKU_SOLUTION[initial_solution.get(random_number)];

            initial_solution.remove(random_number);
            length--;
        }

        for (int i = 0; i < user_solution.length; i++) {

            if (user_solution[i] != 0) {
                grid.set_text(i, String.valueOf(user_solution[i]));
                stack_solution.push(i);
            }
        }
        System.out.println("Game, line 180, printArray(user_solution)");
        Print_Array.print_array(user_solution);
    }

    /**
     * loop the user_solution and copy the values to INITIAL_SOLUTION
     * the INITIAL_SOLUTION array is used to avoid user
     * delete grid button values assigned at initial state
     */
    private void fill_initial_solution() {
        for (int i = 0; i < user_solution.length; i++) {
            INITIAL_SOLUTION[i] = user_solution[i];
        }
    }

    /**
     * save the values of current state
     * pass the values to a instance of State
     * save the instance State to arrayList_state
     */
    protected void add_state() {
        state_number++;
        current_state = state_number;
        int[] copy_user_solution = new int[user_solution.length];
        for (int i = 0; i < user_solution.length; i++) {
            copy_user_solution[i] = user_solution[i];
        }

        Stack<Integer> copy_stack_solution = new Stack<>();
        for (int i = 0; i < stack_solution.size(); i++) {
            copy_stack_solution.push(stack_solution.elementAt(i));
        }

        position = grid.get_grid_position();
        option_position = option.get_option_position();

        state = new State(copy_user_solution, marked_grid_counting,
                            position, option_position,
                            copy_stack_solution);
        arrayList_state.add(state);

        grid.update_current_game(current_state);

    }

    /**
     * called when user click the previous_game button
     * it uses current_state values to navigate
     * arrayListState to previous state.
     * recover the values from the instance saved in
     * arrayListState previous state
     */
    protected void recover_previous_state() {

        if (current_state > 0) {
            current_state--;
            State state_recovered = arrayList_state.get(current_state);
            int[] recovered_user_solution;
            recovered_user_solution = state_recovered.get_user_solution();
            for (int i = 0; i < user_solution.length; i++) {

                user_solution[i] = recovered_user_solution[i];

            }
            marked_grid_counting = state_recovered.get_marked_grid_counting();
            position = state_recovered.get_position();
            option_position = state_recovered.get_option_position();
            Stack<Integer> recovered_stack_solution;
            recovered_stack_solution = state_recovered.get_stack_solution();

            stack_solution.clear();
            for (int i = 0; i < recovered_stack_solution.size(); i++) {
                stack_solution.push(recovered_stack_solution.elementAt(i));
            }

            grid.set_grid_position(position);
            option.set_option_position(option_position);

            repopulate_grid();
        } else {
            System.out.println("Game, line 244, operation not possible");
        }
    }

    /**
     * called when user click the next_game button
     * it uses current_state values to navigate
     * arrayListState to next state.
     * recover the values from the instance saved in
     * arrayListState next state
     */
    protected void recover_next_state() {
        if (current_state < state_number) {
            current_state++;
            State state_recovered = arrayList_state.get(current_state);
            int[] recovered_user_solution;
            recovered_user_solution = state_recovered.get_user_solution();
            for (int i = 0; i < user_solution.length; i++) {

                user_solution[i] = recovered_user_solution[i];
            }
            marked_grid_counting = state_recovered.get_marked_grid_counting();
            position = state_recovered.get_position();
            option_position = state_recovered.get_option_position();
            Stack<Integer> recovered_stack_solution;
            recovered_stack_solution = state_recovered.get_stack_solution();
            stack_solution.clear();

            for (int i = 0; i < recovered_stack_solution.size(); i++) {
                stack_solution.push(recovered_stack_solution.elementAt(i));
            }

            grid.set_grid_position(position);
            option.set_option_position(option_position);
            repopulate_grid();
        } else {
            System.out.println("Game, line 274, operation not possible");
        }
    }

    /**
     * helper method used to reflecting the grid buttons
     * assigned values as in accordance of user state choice.
     */
    private void repopulate_grid() {
        for (int i = 0; i < user_solution.length; i++) {
            if (user_solution[i] != 0) {
                grid.set_text(i, String.valueOf(user_solution[i]));
            } else {
                grid.set_text(i, "");
            }
        }
        // to update the display with current state game number
        grid.update_current_game(current_state);
    }

    /**
     * Remove the last option user choose to fill the grid,
     *      up to the point of initial grid,
     *      initial grid has 42 options already filled
     */
    protected void remove_previous() {
        if (stack_solution.size() > 42) {
            int position_value = stack_solution.pop();
            delete_user_solution(position_value);
        } else {
            System.out.println("Game Line 236 not possible");
        }

    }

    /**
     * to update the count of the number of cells
     * are filled in the Sudoku grid
     */
    protected void update_marked_solution() {
        marked_grid_counting++;
    }

    /**
     * return the number of cells
     * are filled in the Sudoku grid.
     * @return number of cells used
     */
    protected boolean get_marked_solution() {
    //protected int get_marked_solution() {
        boolean grid_completed = true;
        for (int i = 0; i < 81; i++) {
            if (user_solution[i] == 0) {
                grid_completed = false;
            }
        }
        //return marked_grid_counting;
        return grid_completed;
    }

    /**
     * to count the total number of mistakes user commit
     * comparing user solution to sudoku solution
     * @return the total number of wrong choices
     */
    protected int calculate_mistakes() {
        int mistakes = 0;
        for (int i = 0; i < 81; i++) {
            if (user_solution[i] != SUDOKU_SOLUTION[i]) {
                mistakes++;
            }
        }
        return mistakes;
    }

    protected void print_array_user_solutio() {
        Print_Array.print_array(user_solution);
    }
}


