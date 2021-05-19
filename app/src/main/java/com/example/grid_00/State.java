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

    private int[] user_solution;
    private int marked_solution;
    private int position;
    private int option_position;
    private Stack<Integer> stack_solution;


    public State(int[] user_solution,
                 int marked_solution,
                 int position,
                 int option_position,
                 Stack<Integer> stack_solution ) {

        this.user_solution = user_solution;
        this.marked_solution =  marked_solution;
        this.position = position;
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
     * the number of buttons with values already assigned
     * @return marked_solution
     */
    protected int get_marked_solution() {
        return marked_solution;
    }

    /**
     * the position user is plaing
     * @return position
     */
    protected int get_position() {
        return position;
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
