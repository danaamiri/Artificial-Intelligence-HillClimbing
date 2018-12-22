package com.company.EightPuzzle;

import java.util.ArrayList;

public class EightPuzzle {
    private char[][] intialState = {
                                        {'1','2','3'},
                                        {'4','5','6'},
                                        {'7','8','0'}
                                    };
    private StateGenerator stateGenerator = new StateGenerator();
    private GameGenerator gameGenerator = new GameGenerator();
    public GameRules game = new GameRules();
    public EightPuzzle() {
    }

    public ArrayList<char[][]> getStates(){
        return stateGenerator.getStates(intialState);
    }
}
