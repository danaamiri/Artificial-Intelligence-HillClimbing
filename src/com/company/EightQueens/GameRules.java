package com.company.EightQueens;

import java.util.ArrayList;

public class GameRules {

    public ArrayList<ArrayList> getSuccessors(char[][] state,int ie,int je){
        ArrayList<ArrayList> successors = new ArrayList<>();
        ArrayList temp = new ArrayList();
        for(int i = 1;i<=8;i++){
            String move = " ";
            if(checkMove(state, ie, je, i)){
                switch (i){
                    case 1:
                        move = "n";
                        break;
                    case 2:
                        move = "e";
                        break;
                    case 3:
                        move = "s";
                        break;
                    case 4:
                        move = "w";
                        break;
                    case 5:
                        move = "ne";
                        break;
                    case 6:
                        move = "se";
                        break;
                    case 7:
                        move = "sw";
                        break;
                    case 8:
                        move = "nw";
                        break;
                }
                temp.add(move);

            }


        }
        successors.add(temp);
        return successors;
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
