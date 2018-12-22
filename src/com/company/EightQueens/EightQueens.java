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
    public EightQueens() {
        char[][] temp = new char[][]{
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'}};
        System.out.println(heuristic.attackingPairs(temp));


    }
}
