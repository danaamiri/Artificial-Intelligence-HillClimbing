package com.company.EightQueens;

import java.util.ArrayList;
import java.util.Random;

public class StateGenerator {


    public char[][] generateStates() {

        char[][] state = new char[][]{
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0'}};

        for (int i = 0; i < 8; ++i) {
            boolean isOk = false;

            while (!isOk) {
                int x = this.randomQueenPosition();
                int y = this.randomQueenPosition();
                if (state[x][y] == '0') {
                    state[x][y] = '1';
                    isOk = true;
                }
            }
        }
        return state;
    }

    private int randomQueenPosition() {
        Random rnd = new Random();
        int rmd = rnd.nextInt(7) + 1;
        return rmd;
    }
}
