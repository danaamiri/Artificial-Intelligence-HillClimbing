package com.company.EightQueens;

import java.util.ArrayList;

public class QueensHeuristic {
     int attackingPairs(char[][] state){
        int cost = 0;
        char[][] temp = state;
        ArrayList<int[]> queens = new ArrayList<>();
        for(int i = 0;i<8;i++){
            int[] queen = new int[2];
            for(int j = 0;j<8;j++){
                if(temp[i][j] == '1'){
                    queen[0] = i;
                    queen[1] = j;
                    temp[i][j] = '0';
                    queens.add(queen);
                }
            }
        }

        for(int i = 0;i<8;i++){
            int[] queen = queens.get(0);
            for(int j=0;j<queens.size()-1;j++){
                if(i == j){
                    continue;
                }else{
                    int[] tempQueen = queens.get(j);
                    int it = tempQueen[0];
                    int jt = tempQueen[1];
                    if(queen[0] == it || queen[1]==jt || queen[0]-queen[1]==it-jt ||queen[0]+queen[1]==it+jt){
                            cost++;
                    }
                }
            }
            queens.remove(0);
        }
        return ++cost;
    }

/*
    boolean isStraight(char[][] state, ArrayList<int[]> queens, int[] self,int[] target){
        boolean straight = true;
        for(int i=0;i<queens.size();i++){
            int[] tempCoor = queens.get(i);
            int selfDevi = Math.abs(self[0]-target[0]);
            int selfDevj = Math.abs(self[1]-target[1]);
            int sideDevi = Math.abs(self[0]-tempCoor[0]);
            int sideDevj = Math.abs(self[1]-tempCoor[1]);
            if(selfDevi > sideDevi && selfDevj > sideDevj){
                straight = false;
                break;
            }
        }
        return straight;

    }
    */
}
