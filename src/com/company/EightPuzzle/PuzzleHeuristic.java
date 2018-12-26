package com.company.EightPuzzle;

public class PuzzleHeuristic {
    private int manhattanDistance(char[][] state, int ie, int je) {
        int cost = 0;
        char tile = state[ie][je];
        switch (tile) {
            case '1':
                cost = Math.abs(ie - 0) + Math.abs(je - 0);
                break;
            case '2':
                cost = Math.abs(ie - 0) + Math.abs(je - 1);
                break;
            case '3':
                cost = Math.abs(ie - 0) + Math.abs(je - 2);
                break;
            case '4':
                cost = Math.abs(ie - 1) + Math.abs(je - 0);
                break;
            case '5':
                cost = Math.abs(ie - 1) + Math.abs(je - 1);
                break;
            case '6':
                cost = Math.abs(ie - 1) + Math.abs(je - 2);
                break;
            case '7':
                cost = Math.abs(ie - 2) + Math.abs(je - 0);
                break;
            case '8':
                cost = Math.abs(ie - 2) + Math.abs(je - 1);
                break;
        }
        return cost;
    }

    public int linearConflict(char[][] state, int i, int j) {
        int cost = 0;
        return cost;
    }

    public int manhattanCost(char[][] state) {
        int cost = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] != '0') {
                    cost += manhattanDistance(state, i, j);
                }
            }
        }
        return cost;
    }

}
