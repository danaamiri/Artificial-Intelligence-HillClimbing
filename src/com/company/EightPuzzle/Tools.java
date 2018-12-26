package com.company.EightPuzzle;

public class Tools {
    int[] getEmpty(char[][] state) {
        int[] emp = new int[2];
        boolean found = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] == '0') {
                    emp[0] = i;
                    emp[1] = j;
                    found = true;
                }
            }
            if (found) {
                break;
            }
        }
        return emp;
    }

    public boolean checkMoves(char[][] state, int move, int i, int j) {
        boolean ok = false;
        if (state[i][j] == '0') {
            switch (move) {
                case 1:
                    if (i != 0) {
                        ok = true;
                    }
                    break;
                case 2:
                    if (j != 2) {
                        ok = true;
                    }
                    break;
                case 3:
                    if (i != 2) {
                        ok = true;
                    }
                    break;
                case 4:
                    if (j != 0) {
                        ok = true;
                    }
                    break;
            }
        }
        return ok;
    }
}
