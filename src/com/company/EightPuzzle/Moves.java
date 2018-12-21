package com.company.EightPuzzle;

public class Moves {
    private GameRules gameRules = new GameRules();
    GameGenerator gameGenerator = new GameGenerator();
    public char[][] up(char[][] state, int[] empty){
        char[][] temp = state;

        int ie = empty[0];
        int je = empty[1];

        if(gameRules.checkMoves(state,1,ie,je)){
            temp[ie][je] = state[ie-1][je];
            temp[ie-1][je] = '0';
        }else{
            System.out.println("Move not allowed");
        }

        return temp;
    }
    public char[][] right(char[][] state, int[] empty){
        char[][] temp = state;
        int ie = empty[0];
        int je = empty[1];
        if(gameRules.checkMoves(state,2,ie,je)){
            temp[ie][je] = state[ie][je+1];
            temp[ie][je+1] = '0';
        }else{
            System.out.println("Move not allowed");
        }
        return temp;
    }
    public char[][] down(char[][] state, int[] empty){
        char[][] temp = state;
        int ie = empty[0];
        int je = empty[1];
        if(gameRules.checkMoves(state,3,ie,je)){
            temp[ie][je] = state[ie+1][je];
            temp[ie+1][je] = '0';
        }else{
            System.out.println("Move not allowed");
        }
        return temp;
    }
    public char[][] left(char[][] state, int[] empty){
        char[][] temp = state;
        int ie = empty[0];
        int je = empty[1];
        if(gameRules.checkMoves(state,4,ie,je)){
            temp[ie][je] = state[ie][je-1];
            temp[ie][je-1] = '0';
        }else{
            System.out.println("Move not allowed");
        }
        return temp;
    }
}
