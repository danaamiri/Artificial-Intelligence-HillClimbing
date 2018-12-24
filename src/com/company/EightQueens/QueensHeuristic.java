package com.company.EightQueens;

import java.util.ArrayList;

public class QueensHeuristic {
    Tools tools = new Tools();
    GameGenerator gameGenerator = new GameGenerator();
     public int attackingPairs(char[][] state){
        int cost = 0;
        char[][] temp = tools.copyState(state);
        ArrayList<int[]> queens = tools.findQueens(temp);
        for(int i = 0;i<8;i++){
            int[] queen = queens.get(0);
            queens.remove(0);
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

        }
        return cost;
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
