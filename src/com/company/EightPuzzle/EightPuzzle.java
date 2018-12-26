package com.company.EightPuzzle;

public class EightPuzzle {
    public char[][] intialState = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '0'}
    };
    private StateGenerator stateGenerator = new StateGenerator();
    public GameGenerator gameGenerator = new GameGenerator();
    public GameRules game = new GameRules();
    public PuzzleHeuristic heuristic = new PuzzleHeuristic();

    public char[][] getStates() {
        return stateGenerator.getStates(intialState);
    }

    public boolean isSolved(char[][] input) {
        return gameGenerator.printGame(input).equals(gameGenerator.printGame(intialState));
    }
}
