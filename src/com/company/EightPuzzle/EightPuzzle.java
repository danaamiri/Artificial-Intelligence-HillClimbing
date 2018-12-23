package com.company.EightPuzzle;

import java.util.ArrayList;

public class EightPuzzle {
    public char[][] intialState = {
                                        {'1','2','3'},
                                        {'4','5','6'},
                                        {'7','8','0'}
                                    };
    public char[][] nextState = {
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','0'}
    };
    private StateGenerator stateGenerator = new StateGenerator();
    public GameGenerator gameGenerator = new GameGenerator();
    public GameRules game = new GameRules();
    public Moves moves = new Moves();
    public PuzzleHeuristic heuristic = new PuzzleHeuristic();
    private Tools tools = new Tools();
    public EightPuzzle() {
//        System.out.println(heuristic.manhattanCost(nextState));
//        for(int i =0 ;i<game.getSuccessors(nextState).size();i++){
//            System.out.println((int) game.getSuccessors(nextState).get(i).get(3));
//            System.out.println(gameGenerator.printGame((char[][]) game.getSuccessors(nextState).get(i).get(0)));
//
//        }
//        System.out.println((int) game.getBestNeighbor(game.getSuccessors(nextState)).get(3));
    }

    public char[][] getStates(){
        return stateGenerator.getStates(intialState);
    }

    public boolean isSolved(char[][] input){
        return gameGenerator.printGame(input).equals(gameGenerator.printGame(intialState));
    }
}
