package com.company.EightQueens;

import java.util.ArrayList;
import java.util.Random;

public class StateGenerator {
    private GameGenerator gameGenerator = new GameGenerator();

    public StateGenerator() {
    }

    public ArrayList<char[][]> generateStates() {
        ArrayList<char[][]> states = new ArrayList();

        for(int k = 0; k < 12; ++k) {
            char[][] temp = new char[][]{{'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}, {'0', '0', '0', '0', '0', '0', '0', '0'}};

            for(int i = 0; i < 8; ++i) {
                boolean isOk = false;

                while(!isOk) {
                    int x = this.randomQueenPosition();
                    int y = this.randomQueenPosition();
                    if (temp[x][y] == '0') {
                        temp[x][y] = '1';
                        isOk = true;
                    }
                }
            }

            states.add(temp);
        }

        return states;
    }

    private int randomQueenPosition() {
        Random rnd = new Random();
        int rmd = rnd.nextInt(7) + 1;
        return rmd;
    }
}
