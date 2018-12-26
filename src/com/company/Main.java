package com.company;

import com.company.EightPuzzle.EightPuzzle;
import com.company.EightQueens.EightQueens;
import com.company.HillClibmingAlgorithm.HillClimbing;

public class Main {

    public static void main(String[] args) {
        EightPuzzle eightPuzzle = new EightPuzzle();
        EightQueens eightQueens = new EightQueens();
        HillClimbing hillClimbing = new HillClimbing(eightPuzzle, eightQueens);
    }
}
