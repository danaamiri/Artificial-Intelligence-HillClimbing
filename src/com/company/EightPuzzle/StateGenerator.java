package com.company.EightPuzzle;

import java.util.ArrayList;
import java.util.Random;

public class StateGenerator {
    private GameRules gameRules = new GameRules();
    private Moves moves = new Moves();
    private GameGenerator gameGenerator = new GameGenerator();
    public ArrayList<char[][]> getStates(char[][] initial){
        ArrayList<char[][]> states = new ArrayList<>();
        for(int k=0;k<12;k++){
            char[][] temp = initial;
            int movesNumber = movesNumber();
            for(int i = 0;i<movesNumber;i++){
                int[] emp = getEmpty(temp);
                int movesDirection;
                while (true) {
                    movesDirection = movesDirection();
                    if (gameRules.checkMoves(temp, movesDirection, emp[0], emp[1])) {
                        break;
                    }
                }
                switch (movesDirection){
                    case 1:
                        temp = moves.up(temp,emp);
                        break;
                    case 2:
                        temp = moves.right(temp,emp);
                        break;
                    case 3:
                        temp = moves.down(temp,emp);
                        break;
                    case 4:
                        temp = moves.left(temp,emp);
                        break;
                }
            }
            states.add(temp);

        }

        return states;
    }

    private int movesNumber(){
        Random rnd = new Random();
        int rmd = rnd.nextInt(100) + 1;
        return rmd;
    }

    private int movesDirection(){
        Random rnd = new Random();
        int rmd = rnd.nextInt(4) + 1;
        return rmd;
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
