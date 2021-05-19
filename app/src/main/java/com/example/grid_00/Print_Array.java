/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class Print_Array
 * the purpose of this class is debugger use.
 * it provide method to print the values of:
 * array, arrayList and Stack.
 */

package com.example.grid_00;

import java.util.ArrayList;
import java.util.Stack;

public class Print_Array {

    /////////////////////////////////////////////////////////////////////////////////
    // for debugging use:
    /////////////////////////////////////////////////////////////////////////////////
    static void print_array_list(ArrayList<Integer> array_to_print) {

        for (int i = 0; i < array_to_print.size(); i++) {
            System.out.print(" " + array_to_print.get(i) + "  ");
            if ((i + 1) % 3 == 0) {
                System.out.print("|");
            }
            if ((i + 1) % 9 == 0) {
                System.out.println();
            }
            if ((i + 1) % 27 == 0) {
                System.out.println(
                        "-------------------------------------");
            }
        }
        System.out.println();
    }
    static void print_array (int[] arrayToPrint) {
        System.out.println(
                "------------" + arrayToPrint.toString() + "---------------------------");
        for (int i = 0; i < arrayToPrint.length; i++) {
            System.out.print(" " + arrayToPrint[i] + "  ");
            if ((i + 1) % 3 == 0) {
                System.out.print("|");
            }
            if ((i + 1) % 9 == 0) {
                System.out.println();
            }
            if ((i + 1) % 27 == 0) {
                System.out.println(
                        "---------------------------------------");
            }
        }
    }
    static void print_array_boolean (boolean[] arrayToPrint) {
        System.out.println(
                "-----------------" + arrayToPrint.toString() + "----------------------");
        for (int i = 0; i < arrayToPrint.length; i++) {
            boolean toPrint = arrayToPrint[i];
            if (toPrint) {
                System.out.print(" T ");
            } else {
                System.out.print(" F ");
            }
            //System.out.print(" " + arrayToPrint[i] + "  ");
            if ((i + 1) % 3 == 0) {
                System.out.print("|");
            }
            if ((i + 1) % 9 == 0) {
                System.out.println();
            }
            if ((i + 1) % 27 == 0) {
                System.out.println(
                        "---------------------------------------");
            }
        }
    }

    static void print_stack(Stack<Integer> stack_name) {
        for (int i = 0; i < stack_name.size(); i++) {
            System.out.print(stack_name.elementAt(i) + "  ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
