/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class Option
 * the purpose of this class is to save the buttons available to
 * user select their value.
 * The button option value  can fill remaining grid buttons
 * without assigned value.
 * The option buttons are saved in an array.
 * The array has a capacity to hold 9 buttons,
 * button 0, means to fill value 1, ... button 8, to fill value 9.
 */

package com.example.grid_00;

import android.widget.Button;

public class Option {

    // the array to hold the buttons available to choose grid input
    private Button[] option;
    // the index of current option position
    private int option_position;

    public Option() {

        option = new Button[9];
        option_position = 0;
    }

    /**
     * add buttons to array option
     * @param index the index to add the button
     * @param button to button to add to option[]
     */
    protected void add_button(int index, Button button) {
        option[index] = button;
    }

    /**
     * return Button from option[]
     * @param index the index of option[]
     * @return the button at index
     */
    protected Button get_button(int index) {
        return option[index];
    }

    /**
     * set option button to choice of background color
     * @param index the index of the button to change background color
     * @param color the color to update background
     */
    protected void set_background_color(int index, int color) {
        option[index].setBackgroundColor(color);
    }

    /**
     * set option button to choice of text color
     * @param index the index of the button to change text color
     * @param color the color to update text
     */
    protected void set_text_color(int index, int color) {
        option[index].setTextColor(color);
    }

    /**
     * to update the current option_position
     * @param index the index of the new current option_position
     */
    protected void set_option_position(int index) {
        option_position = index;
    }

    /**
     * the index of the current option_positon
     * @return index option_position
     */
    protected int get_option_position() {
        return option_position;
    }

    /**
     * add the value of option_position + 1
     * convert the value to a string
     * return the value
     * @return String value of option_position + 1
     */
    protected String get_option_string_value() {
        return String.valueOf(option_position + 1);
    }

    /**
     * Return the int value of the option at position at index
     * example: position 0, has the option value of 1
     * the position value add 1 to adjust
     * @param index the index of option[]
     * @return an int value assign to Button at option[index]
     */
    protected int get_option_int_value(int index) {
        String string_value = option[index].getText().toString();
        return Integer.parseInt(string_value + 1);
    }
}
