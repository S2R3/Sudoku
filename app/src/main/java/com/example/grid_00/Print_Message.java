/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class Print_Message
 * the purpose of this class is for debugger use.
 */

package com.example.grid_00;

public class Print_Message {

    static void message_int(String class_name, int line, String message, int deduger) {

        System.out.println(class_name + " " + line + " " + message + " :" + deduger);
    }
}
