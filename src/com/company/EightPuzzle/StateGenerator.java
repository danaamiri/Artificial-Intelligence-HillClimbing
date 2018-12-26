package com.company.EightPuzzle;

import java.util.Random;

public class StateGenerator {
    private Tools tools = new Tools();
    private Moves moves = new Moves();

    char[][] getStates(char[][] initial) {

        char[][] temp = initial;
        int movesNumber = movesNumber();
        for (int i = 0; i < movesNumber; i++) {
            int[] emp = tools.getEmpty(temp);
            int movesDirection = movesDirection();
            while (!tools.checkMoves(temp, movesDirection, emp[0], emp[1])) {
                movesDirection = movesDirection();
            }
            switch (movesDirection) {
                case 1:
                    temp = moves.up(temp, emp);
                    break;
                case 2:
                    temp = moves.right(temp, emp);
                    break;
                case 3:
                    temp = moves.down(temp, emp);
                    break;
                case 4:
                    temp = moves.left(temp, emp);
                    break;
            }
        }


        return temp;
    }

    private int movesNumber() {
        Random rnd = new Random();
        int rmd = rnd.nextInt(100) + 1;
        return rmd;
    }

    private int movesDirection() {
        Random rnd = new Random();
        int rmd = rnd.nextInt(4) + 1;
        return rmd;
    }


}
