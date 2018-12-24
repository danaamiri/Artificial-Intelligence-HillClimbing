package com.company.HillClibmingAlgorithm;

import com.company.EightPuzzle.EightPuzzle;
import com.company.EightPuzzle.GameGenerator;
import com.company.EightQueens.EightQueens;

import java.util.ArrayList;

public class HillClimbing {
    EightPuzzle eightPuzzle;
    EightQueens eightQueens;
    com.company.EightQueens.GameGenerator gameGenerator = new com.company.EightQueens.GameGenerator();

    public HillClimbing(EightPuzzle eightPuzzle, EightQueens eightQueens) {
        this.eightPuzzle = eightPuzzle;
        this.eightQueens = eightQueens;
        run();
    }

    public char[][] hillClimbing(EightPuzzle problem){
        Node current = new Node(problem.getStates(),-1,problem.heuristic.manhattanCost(problem.getStates()));
        Node neighbor;
        ArrayList neighborTemp;
        while (true){
            neighborTemp =problem.game.getBestNeighbor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(3));
            if(current.value<=neighbor.value){
               return current.state;
            }
            current = neighbor;


        }
    }
    public char[][] hillClimbing(EightQueens problem){
        Node current = new Node(problem.getState(),-1,problem.heuristic.attackingPairs(problem.getState()));
//        System.out.println(gameGenerator.printGame(current.state));
//        System.out.println(current.value);
        Node neighbor;
        ArrayList neighborTemp;
        while (true){
            neighborTemp =problem.game.getBestSuccessor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(2));
//            System.out.println(gameGenerator.printGame(neighbor.state));
//            System.out.println(neighbor.value);
            if(current.value<=neighbor.value){
                return current.state;
            }
            current = neighbor;
        }
    }

    void run() {
        int total = 0;
        int solved = 0;
        int attempts = 1000;
        float winPercentage;
        long start = System.currentTimeMillis();
        //hill Climbing for 8Puzzle
        for (int i = 0; i < attempts; i++) {
            if (eightPuzzle.isSolved(hillClimbing(eightPuzzle))) {
                solved++;
            }
            total++;
        }
        long end = System.currentTimeMillis();
        long durationTime = end - start;
        winPercentage = (float) solved / (float) total * 100;
        System.out.println("=======================Statistics===================");
        System.out.printf("                    For %d Attempts                 \n", attempts);
        System.out.println("====================================================");
        System.out.println("  Algorithm      : Hill Climbing - Steepest Ascent  ");
        System.out.println("  Problem        : 8Puzzle                          ");
        System.out.printf( "  Win Percentage : %%%f                             \n", winPercentage);
        System.out.printf( "  Execution time : %d ms                            \n", durationTime);
        System.out.println("====================================================");


        total = 0;
        solved = 0;
        attempts = 1000;
        start = System.currentTimeMillis();
        //hill Climbing for 8Queens
        for (int i = 0; i < attempts; i++) {
            if (eightQueens.isSolved(hillClimbing(eightQueens))) {
                solved++;
            }
            total++;
        }
        end = System.currentTimeMillis();
        durationTime = end - start;
        winPercentage = (float) solved / (float) total * 100;
        System.out.println("=======================Statistics===================");
        System.out.printf("                    For %d Attempts                 \n", attempts);
        System.out.println("====================================================");
        System.out.println("  Algorithm      : Hill Climbing - Steepest Ascent  ");
        System.out.println("  Problem        : 8Queens                         ");
        System.out.printf( "  Win Percentage : %%%f                             \n", winPercentage);
        System.out.printf( "  Execution time : %d ms                            \n", durationTime);
        System.out.println("====================================================");
    }
}

