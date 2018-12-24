package com.company.EightQueens;

import com.company.EightPuzzle.PuzzleHeuristic;
import com.company.EightQueens.GameGenerator;
import com.company.EightQueens.StateGenerator;

import java.util.ArrayList;

public class EightQueens {
    private GameGenerator gameGenerator = new GameGenerator();
    private StateGenerator stateGenerator = new StateGenerator();
    public GameRules game = new GameRules();
    public Moves moves = new Moves();
    public QueensHeuristic heuristic = new QueensHeuristic();
    Tools tools = new Tools();
    public char[][] state = new char[][]{
            {'0', '0', '0', '0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '1', '0'},
            {'1', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '1'},
            {'0', '1', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0', '0', '0', '0'}};
    public EightQueens() {
//        ArrayList<ArrayList> suc = game.getSuccessors(state);
//        for(int i=0;i<suc.size();i++){
//            ArrayList temp = suc.get(i);
//            System.out.println("+++++++++++++++++++++++++++++++");
//            System.out.println((int) temp.get(2));
//            System.out.println(gameGenerator.printGame((char[][]) temp.get(0)));
//            System.out.println("+++++++++++++++++++++++++++++++");
//        }
    }

    public char[][] getState(){
         return stateGenerator.generateStates();
    }


    public boolean isSolved(char[][] state){
        if(heuristic.attackingPairs(state)==0){
            return true;
        }
        return false;

    }


}
