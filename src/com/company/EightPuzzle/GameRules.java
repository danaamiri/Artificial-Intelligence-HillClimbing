package com.company.EightPuzzle;

import java.util.ArrayList;

public class GameRules {
    public boolean checkMoves(char[][] state, int move, int i,int j){
        boolean ok = false;
        switch (move){
            case 1:
                if(i != 0){
                    ok = true;
                }
                break;
            case 2:
                if(j != 2){
                    ok = true;
                }
                break;
            case 3:
                if(i != 2){
                    ok = true;
                }
                break;
            case 4:
                if(j != 0){
                    ok = true;
                }
                break;
        }

        return ok;
    }

    public ArrayList<ArrayList> getSuccessors(char[][] state){
        ArrayList<ArrayList> successors = new ArrayList<>();

        char move = ' ';
        int[] dest = new int[2];
        int[] st = getEmpty(state);
        int ie = st[0];
        int je = st[1];
        for(int i =1;i<=4;i++){
            ArrayList temp  = new ArrayList();
            if(checkMoves(state,i,ie,je)){
                switch (i){
                    case 1:
                        move = 'U';
                        dest[0] = ie-1;
                        dest[1] = je;
                        break;
                    case 2:
                        move = 'R';
                        dest[0] = ie;
                        dest[1] = je+1;
                        break;
                    case 3:
                        move = 'D';
                        dest[0] = ie+1;
                        dest[1] = je;
                        break;
                    case 4:
                        move = 'L';
                        dest[0] = ie;
                        dest[1] = je-1;
                        break;

                }
                temp.add(move);
                temp.add(dest);
                successors.add(temp);
            }

        }
        return successors;
    }

    private int[] getEmpty(char[][] state){
        int[] emp = new int[2];
        boolean found = false;
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(state[i][j]=='0'){
                    emp[0]= i;
                    emp[1]= j;
                    found = true;
                }
            }
            if(found){
                break;
            }
        }
        return emp;
    }
}
