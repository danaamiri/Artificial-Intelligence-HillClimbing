package com.company.EightPuzzle;

public class Moves {

    private Tools tools = new Tools();

    char[][] up(char[][] state, int[] empty) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = state[i][j];
            }
        }
        int ie = empty[0];
        int je = empty[1];

        if (tools.checkMoves(state, 1, ie, je)) {
            temp[ie][je] = temp[ie - 1][je];
            temp[ie - 1][je] = '0';
        } else {
            System.out.println("Move not allowed");
        }

        return temp;
    }

    char[][] right(char[][] state, int[] empty) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = state[i][j];
            }
        }
        int ie = empty[0];
        int je = empty[1];
        if (tools.checkMoves(state, 2, ie, je)) {
            temp[ie][je] = temp[ie][je + 1];
            temp[ie][je + 1] = '0';
        } else {
            System.out.println("Move not allowed");
        }
        return temp;
    }

    char[][] down(char[][] state, int[] empty) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = state[i][j];
            }
        }
        int ie = empty[0];
        int je = empty[1];
        if (tools.checkMoves(state, 3, ie, je)) {
            temp[ie][je] = temp[ie + 1][je];
            temp[ie + 1][je] = '0';
        } else {
            System.out.println("Move not allowed");
        }
        return temp;
    }

    char[][] left(char[][] state, int[] empty) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = state[i][j];
            }
        }
        int ie = empty[0];
        int je = empty[1];
        if (tools.checkMoves(state, 4, ie, je)) {
            temp[ie][je] = temp[ie][je - 1];
            temp[ie][je - 1] = '0';
        } else {
            System.out.println("Move not allowed");
        }
        return temp;
    }


}
