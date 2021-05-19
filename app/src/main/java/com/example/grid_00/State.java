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
    private int state_number;
    // the position of option key button
    private int option_position;
    // the stack of user input in sequence.
    private Stack<Integer> stack_solution;


    public State(int[] user_solution,
                 int position,
                 int option_position,
                 Stack<Integer> stack_solution ) {

        this.user_solution = user_solution;
        this.state_number = position;
        this.option_position = option_position;
        this.stack_solution = stack_solution;
    }

    /**
     * the array with the user input solution
     * @return int[] user_solution
     */
    protected int[] get_user_solution() {
        return user_solution;
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
