/*
 * CS443 - Spring 2021
 * Sergio Augusto De Sa
 *
 * Class Sudoku
 *
 * The purpose of this class is provide the solution to Sudoku.
 * There are 4 solutions saved in this game.
 * Each new instance of this class will random draw the first row.
 * Once the first row is choose, the values of the first row will
 * map the solutions saved.
 * For example:
 *    - the random choose the solution number 1.
 *    - the random choose the number 5 to be the first position
 * of the first row.
 *    - The int one will have the value 5, and it will save 5 to
 * positions 0, 14, 24, 28, 40, 52, 74, 57 and 71.
 *    - Each of the remaining int with number named will have the position
 * where they have to assign the value attribute to them.
 *    - Each additional instance of this class will likely have a
 * different solution.
 **/
package com.example.grid_00;

import java.util.ArrayList;
import java.util.Random;

public class Sudoku {

    private Random random;
    private int[] sudoku;
    private ArrayList<Integer> first_row;
    private ArrayList<Integer> to_draw;

    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int seven;
    private int eight;
    private int nine;
    private int index;

    public Sudoku() {
        first_row = new ArrayList<>();
        to_draw = new ArrayList<>();
        sudoku = new int[81];
        random = new Random();

        fill_arrays();
        fill_values();

        // there are 4 saved solutions.
        // random choose one saved solution.
        index = random.nextInt(4) + 1;

        switch(index) {
            case 1:
                fill_grid_op_01();
                break;

            case 2:
                fill_grid_op_02();
                break;
            case 3:
                fill_grid_op_03();
                break;
            case 4:
                fill_grid_op_04();
                break;
        }
        Print_Array.print_array(sudoku);
    }

    /**
     * return the sudoku[index]
     * @param index the index to find the value
     * @return the value of sudoku at index
     */
    protected int get_sudoku(int index) {
        return sudoku[index];
    }

    /**
     * ArrayList to_dram is used to give values to random draw
     * Random draw 9 times from to complete the first row of Sudoku
     * The random first row map one of the 4 saved solutions, and
     * change the values to match the ones on the first row.
     */
    private void fill_arrays() {
        for (int i = 1; i < 10; i++) {
            to_draw.add(i);
        }
        //Random random = new Random();
        for (int i = 0; i < 9; i++) {
            int index = random.nextInt(to_draw.size());
            first_row.add(to_draw.get(index));
            to_draw.remove(index);
        }
    }

    /**
     * each int variable get one of the values from the random first row.
     * Ex: int one get the first index on  the first row.
     */
    private void fill_values() {
        one = first_row.get(0);
        two = first_row.get(1);
        three = first_row.get(2);
        four = first_row.get(3);
        five = first_row.get(4);
        six = first_row.get(5);
        seven = first_row.get(6);
        eight = first_row.get(7);
        nine = first_row.get(8);
    }

    /**
     * THere are 4 saved solutions below.
     * fill_grid_op_01 is the first, the others are 02, 03, ..04.
     * each entry on the random first row will map one of the 4 solutions.
     * Since the first row will be random, and there are 4 solutions,
     * Each Sudoku solution will have 9*8*7*6*5*4*2*1 possibilities.
     */

    /**
     * fill the solution one
     */
    private void fill_grid_op_01() {
        // fill the positions assigned to one.
        sudoku[0]  = one;
        sudoku[14] = one;
        sudoku[24] = one;
        sudoku[28] = one;
        sudoku[40] = one;
        sudoku[52] = one;
        sudoku[74] = one;
        sudoku[57] = one;
        sudoku[71] = one;

        // fill the the positions assign to two.
        sudoku[1]  = two;
        sudoku[21] = two;
        sudoku[15] = two;
        sudoku[47] = two;
        sudoku[41] = two;
        sudoku[35] = two;
        sudoku[72] = two;
        sudoku[58] = two;
        sudoku[70] = two;

        // fill 3
        sudoku[2] = three;
        sudoku[22] = three;
        sudoku[16] = three;
        sudoku[36] = three;
        sudoku[50] = three;
        sudoku[33] = three;
        sudoku[73] = three;
        sudoku[66] = three;
        sudoku[62] = three;

        // fill 4
        sudoku[3]  = four;
        sudoku[9]  = four;
        sudoku[25] = four;
        sudoku[38] = four;
        sudoku[31] = four;
        sudoku[53] = four;
        sudoku[55] = four;
        sudoku[77] = four;
        sudoku[69] = four;

        // fill 5
        sudoku[4] = five;
        sudoku[10] = five;
        sudoku[26] = five;
        sudoku[45] = five;
        sudoku[30] = five;
        sudoku[42] = five;
        sudoku[65] = five;
        sudoku[59] = five;
        sudoku[79] = five;

        // fill 6
        sudoku[5]  = six;
        sudoku[20] = six;
        sudoku[17] = six;
        sudoku[27] = six;
        sudoku[39] = six;
        sudoku[51] = six;
        sudoku[64] = six;
        sudoku[76] = six;
        sudoku[61] = six;

        // fill 7
        sudoku[6]  = seven;
        sudoku[19] = seven;
        sudoku[13] = seven;
        sudoku[29] = seven;
        sudoku[48] = seven;
        sudoku[43] = seven;
        sudoku[54] = seven;
        sudoku[68] = seven;
        sudoku[80] = seven;

        // fill 8
        sudoku[7]  = eight;
        sudoku[18] = eight;
        sudoku[12] = eight;
        sudoku[46] = eight;
        sudoku[32] = eight;
        sudoku[44] = eight;
        sudoku[56] = eight;
        sudoku[67] = eight;
        sudoku[78] = eight;

        // fill 9
        sudoku[8]  = nine;
        sudoku[11] = nine;
        sudoku[23] = nine;
        sudoku[37] = nine;
        sudoku[49] = nine;
        sudoku[34] = nine;
        sudoku[63] = nine;
        sudoku[75] = nine;
        sudoku[60] = nine;

    }

    private void fill_grid_op_02() {
        // fill 1
        sudoku[0]  = one;
        sudoku[12] = one;
        sudoku[25] = one;
        sudoku[38] = one;
        sudoku[31] = one;
        sudoku[53] = one;
        sudoku[64] = one;
        sudoku[59] = one;
        sudoku[78] = one;

        // fill 2
        sudoku[1]  = two;
        sudoku[14] = two;
        sudoku[26] = two;
        sudoku[45] = two;
        sudoku[39] = two;
        sudoku[34] = two;
        sudoku[56] = two;
        sudoku[76] = two;
        sudoku[69] = two;

        // fill 3
        sudoku[2] = three;
        sudoku[22] = three;
        sudoku[15] = three;
        sudoku[37] = three;
        sudoku[32] = three;
        sudoku[52] = three;
        sudoku[54] = three;
        sudoku[66] = three;
        sudoku[80] = three;

        // fill 4
        sudoku[3]  = four;
        sudoku[16]  = four;
        sudoku[20] = four;
        sudoku[36] = four;
        sudoku[49] = four;
        sudoku[35] = four;
        sudoku[73] = four;
        sudoku[68] = four;
        sudoku[60] = four;

        // fill 5
        sudoku[4] = five;
        sudoku[10] = five;
        sudoku[24] = five;
        sudoku[27] = five;
        sudoku[50] = five;
        sudoku[43] = five;
        sudoku[65] = five;
        sudoku[75] = five;
        sudoku[62] = five;

        // fill 6
        sudoku[5]  = six;
        sudoku[18] = six;
        sudoku[17] = six;
        sudoku[46] = six;
        sudoku[40] = six;
        sudoku[33] = six;
        sudoku[74] = six;
        sudoku[57] = six;
        sudoku[70] = six;

        // fill 7
        sudoku[6]  = seven;
        sudoku[19] = seven;
        sudoku[13] = seven;
        sudoku[29] = seven;
        sudoku[48] = seven;
        sudoku[44] = seven;
        sudoku[63] = seven;
        sudoku[77] = seven;
        sudoku[61] = seven;

        // fill 8
        sudoku[7]  = eight;
        sudoku[11] = eight;
        sudoku[21] = eight;
        sudoku[28] = eight;
        sudoku[41] = eight;
        sudoku[51] = eight;
        sudoku[72] = eight;
        sudoku[58] = eight;
        sudoku[71] = eight;

        // fill 9
        sudoku[8]  = nine;
        sudoku[9] = nine;
        sudoku[23] = nine;
        sudoku[47] = nine;
        sudoku[30] = nine;
        sudoku[42] = nine;
        sudoku[55] = nine;
        sudoku[67] = nine;
        sudoku[79] = nine;

    }

    private void fill_grid_op_03() {
        // fill 1
        sudoku[0]  = one;
        sudoku[13] = one;
        sudoku[25] = one;
        sudoku[46] = one;
        sudoku[41] = one;
        sudoku[35] = one;
        sudoku[56] = one;
        sudoku[66] = one;
        sudoku[78] = one;

        // fill 2
        sudoku[1]  = two;
        sudoku[14] = two;
        sudoku[24] = two;
        sudoku[38] = two;
        sudoku[30] = two;
        sudoku[52] = two;
        sudoku[72] = two;
        sudoku[67] = two;
        sudoku[62] = two;

        // fill 3
        sudoku[2] = three;
        sudoku[23] = three;
        sudoku[15] = three;
        sudoku[45] = three;
        sudoku[40] = three;
        sudoku[34] = three;
        sudoku[55] = three;
        sudoku[75] = three;
        sudoku[71] = three;

        // fill 4
        sudoku[19]  = four;
        sudoku[3]  = four;
        sudoku[16] = four;
        sudoku[29] = four;
        sudoku[50] = four;
        sudoku[44] = four;
        sudoku[63] = four;
        sudoku[76] = four;
        sudoku[60] = four;

        // fill 5
        sudoku[20] = five;
        sudoku[4] = five;
        sudoku[17] = five;
        sudoku[37] = five;
        sudoku[48] = five;
        sudoku[33] = five;
        sudoku[54] = five;
        sudoku[77] = five;
        sudoku[70] = five;

        // fill 6
        sudoku[10]  = six;
        sudoku[5] = six;
        sudoku[26] = six;
        sudoku[36] = six;
        sudoku[31] = six;
        sudoku[51] = six;
        sudoku[65] = six;
        sudoku[57] = six;
        sudoku[79] = six;

        // fill 7
        sudoku[9]  = seven;
        sudoku[22] = seven;
        sudoku[6] = seven;
        sudoku[28] = seven;
        sudoku[39] = seven;
        sudoku[53] = seven;
        sudoku[74] = seven;
        sudoku[68] = seven;
        sudoku[61] = seven;

        // fill 8
        sudoku[18]  = eight;
        sudoku[12] = eight;
        sudoku[7] = eight;
        sudoku[47] = eight;
        sudoku[32] = eight;
        sudoku[42] = eight;
        sudoku[64] = eight;
        sudoku[58] = eight;
        sudoku[80] = eight;

        // fill 9
        sudoku[11]  = nine;
        sudoku[21] = nine;
        sudoku[8] = nine;
        sudoku[27] = nine;
        sudoku[49] = nine;
        sudoku[43] = nine;
        sudoku[73] = nine;
        sudoku[59] = nine;
        sudoku[69] = nine;

    }

    private void fill_grid_op_04() {
        // fill 1
        sudoku[0]  = one;
        sudoku[15] = one;
        sudoku[21] = one;
        sudoku[31] = one;
        sudoku[43] = one;
        sudoku[47] = one;
        sudoku[59] = one;
        sudoku[64] = one;
        sudoku[80] = one;

        // fill 2
        sudoku[1]  = two;
        sudoku[13] = two;
        sudoku[24] = two;
        sudoku[27] = two;
        sudoku[39] = two;
        sudoku[52] = two;
        sudoku[56] = two;
        sudoku[71] = two;
        sudoku[77] = two;

        // fill 3
        sudoku[2] = three;
        sudoku[12] = three;
        sudoku[26] = three;
        sudoku[34] = three;
        sudoku[36] = three;
        sudoku[50] = three;
        sudoku[55] = three;
        sudoku[67] = three;
        sudoku[78] = three;

        // fill 4
        sudoku[3]  = four;
        sudoku[10]  = four;
        sudoku[25] = four;
        sudoku[29] = four;
        sudoku[40] = four;
        sudoku[53] = four;
        sudoku[60] = four;
        sudoku[68] = four;
        sudoku[72] = four;

        // fill 5
        sudoku[4] = five;
        sudoku[17] = five;
        sudoku[18] = five;
        sudoku[33] = five;
        sudoku[41] = five;
        sudoku[46] = five;
        sudoku[57] = five;
        sudoku[70] = five;
        sudoku[74] = five;

        // fill 6
        sudoku[5]  = six;
        sudoku[16] = six;
        sudoku[19] = six;
        sudoku[35] = six;
        sudoku[38] = six;
        sudoku[49] = six;
        sudoku[54] = six;
        sudoku[69] = six;
        sudoku[75] = six;

        // fill 7
        sudoku[6]  = seven;
        sudoku[11] = seven;
        sudoku[22] = seven;
        sudoku[32] = seven;
        sudoku[44] = seven;
        sudoku[45] = seven;
        sudoku[61] = seven;
        sudoku[66] = seven;
        sudoku[73] = seven;

        // fill 8
        sudoku[7]  = eight;
        sudoku[9] = eight;
        sudoku[23] = eight;
        sudoku[28] = eight;
        sudoku[42] = eight;
        sudoku[48] = eight;
        sudoku[62] = eight;
        sudoku[65] = eight;
        sudoku[76] = eight;

        // fill 9
        sudoku[8]  = nine;
        sudoku[14] = nine;
        sudoku[20] = nine;
        sudoku[30] = nine;
        sudoku[37] = nine;
        sudoku[51] = nine;
        sudoku[58] = nine;
        sudoku[63] = nine;
        sudoku[79] = nine;

    }
}
