package com.company.EightQueens;

import java.util.ArrayList;

public class Tools {
    GameGenerator gameGenerator = new GameGenerator();
    public char[][] copyState(char[][] state){
        char[][] temp = new char[8][8];
        for(int i = 0;i<8;i++){
            for(int j=0;j<8;j++){
                temp[i][j] = state[i][j];
            }
        }
        return temp;
    }
    

    public ArrayList<int[]> findQueens(char[][] state){
        ArrayList<int[]> queens = new ArrayList<>();
        char[][] temp = copyState(state);
        for(int i = 0;i<8;i++){

            for(int j = 0;j<8;j++){
                int[] queen = new int[2];
                if(temp[i][j] == '1'){
                    queen[0] = i;
                    queen[1] = j;
                    temp[i][j] = '0';
                    queens.add(queen);
                }

            }
        }
        return queens;
    }

    public boolean checkMove(char[][] state, int ie, int je, int move){
        boolean ok = false;
        switch (move){
            case 1:
                if(ie != 0 && state[ie-1][je] != '1'){
                    ok = true;
                }
                break;
            case 2:
                if(je != 7 && state[ie][je+1] != '1'){
                    ok = true;
                }
                break;
            case 3:
                if(ie != 7 && state[ie+1][je] != '1'){
                    ok = true;
                }
                break;
            case 4:
                if(je != 0 && state[ie][je-1] != '1'){
                    ok = true;
                }
                break;
            case 5:
                if(ie != 0 && je != 7 && state[ie-1][je+1] != '1'){
                    ok = true;
                }
                break;
            case 6:
                if(ie != 7 && je != 7 && state[ie+1][je+1] != '1'){
                    ok = true;
                }
                break;
            case 7:
                if(ie != 7 && je != 0 && state[ie+1][je-1] != '1'){
                    ok = true;
                }
                break;
            case 8:
                if(ie != 0 && je != 0 && state[ie-1][je-1] != '1'){
                    ok = true;
                }
                break;
        }
        return ok;
    }
}
