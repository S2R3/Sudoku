/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class State
 *
 * The purpose of this class is to save the state of the game.
 **/

package com.example.grid_00;

import java.util.Stack;

public class State {

    // the array that hold the values user filled the grid
    private int[] user_solution;
    // to track the total cells is assigned in grid Sudoku
    private int marked_grid_counting;
    // to track the state number to handle
    private int state_number;
    // the position of option key button
    private int option_position;
    // the stack of user input in sequence.
    private Stack<Integer> stack_solution;


    public State(int[] user_solution,
                 int marked_solution,
                 int position,
                 int option_position,
                 Stack<Integer> stack_solution ) {

        this.user_solution = user_solution;
        this.marked_grid_counting =  marked_solution;
        this.state_number = position;
        this.option_position = option_position;
        this.stack_solution = stack_solution;

        //System.out.println("State, line 26, the array of this state ");
        //Print_Array.print_array(user_solution);
    }

    /**
     * the array with the user input solution
     * @return int[] user_solution
     */
    protected int[] get_user_solution() {
        return user_solution;
    }

    /**
     * the total number of buttons with values already assigned
     * in the Sudoku grid
     * @return marked_solution
     */
    protected int get_marked_grid_counting() {
        return marked_grid_counting;
    }

    /**
     * the position user is plaing
     * @return position
     */
    protected int get_position() {
        return state_number;
    }

    /**
     * the value option to filled the button
     * @return option_position
     */
    protected int get_option_position() {
        return option_position;
    }

    /**
     * the stack to save the sequence of user choices
     * @return stack_solution
     */
    protected Stack<Integer> get_stack_solution() {
        return stack_solution;
    }
}
