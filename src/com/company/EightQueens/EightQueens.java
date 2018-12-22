package com.company.EightQueens;

import com.company.EightQueens.GameGenerator;
import com.company.EightQueens.StateGenerator;

import java.util.ArrayList;

public class EightQueens {
    private GameGenerator gameGenerator = new GameGenerator();
    private StateGenerator stateGenerator = new StateGenerator();
    public GameRules game = new GameRules();
    public Moves moves = new Moves();
    public EightQueens() {
        char[][] temp = new char[][]{
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '1', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'},
                    {'0', '0', '0', '0', '0', '0', '0', '0'}};
        System.out.println(gameGenerator.printGame(temp));
        temp = moves.nw(temp,1,6);
        System.out.println(gameGenerator.printGame(temp));


    }
}
