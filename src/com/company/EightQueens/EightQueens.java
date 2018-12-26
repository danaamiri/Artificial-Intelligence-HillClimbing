package com.company.EightQueens;

public class EightQueens {
    private StateGenerator stateGenerator = new StateGenerator();
    public GameRules game = new GameRules();
    public QueensHeuristic heuristic = new QueensHeuristic();
    public char[][] state = new char[][]{
            {'0', '0', '0', '0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '1', '0'},
            {'1', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '1'},
            {'0', '1', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '0', '0', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0', '0', '0', '0'}};

    public char[][] getState() {
        return stateGenerator.generateStates();
    }


    public boolean isSolved(char[][] state) {
        if (heuristic.attackingPairs(state) == 0) {
            return true;
        }
        return false;

    }


}
