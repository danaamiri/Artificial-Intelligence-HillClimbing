package com.company.HillClibmingAlgorithm;

import com.company.EightPuzzle.EightPuzzle;
import com.company.EightQueens.EightQueens;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HillClimbing {
    EightPuzzle eightPuzzle;
    EightQueens eightQueens;
    com.company.EightQueens.GameGenerator gameGenerator = new com.company.EightQueens.GameGenerator();

    public HillClimbing(EightPuzzle eightPuzzle, EightQueens eightQueens) {
        this.eightPuzzle = eightPuzzle;
        this.eightQueens = eightQueens;
        run();
    }

    public char[][] hillClimbingSteepestAscent(EightPuzzle problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.manhattanCost(initialState));
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
    public char[][] hillClimbingSteepestAscent(EightQueens problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.attackingPairs(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        while (true){
            neighborTemp =problem.game.getBestSuccessor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(2));
            if(current.value<=neighbor.value){
                return current.state;
            }
            current = neighbor;
        }
    }


    public char[][] hillClimbingFirstChoice(EightPuzzle problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.manhattanCost(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        ArrayList<ArrayList> successorTemp;
        while (true){
            successorTemp = problem.game.getSuccessors(current.state);
            neighborTemp =problem.game.getBestNeighbor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(3));
            for(int i = 0;i<successorTemp.size();i++){
                ArrayList stateTemp = problem.game.moveOneStep(successorTemp,i);
                if((int) stateTemp.get(3)<current.value){
                    neighbor = new Node((char[][])stateTemp.get(0),(int) stateTemp.get(1),(int) stateTemp.get(3));
                    break;
                }
            }
            if(current.value<=neighbor.value){
                return current.state;
            }
            current = neighbor;


        }
    }
    public char[][] hillClimbingFirstChoice(EightQueens problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.attackingPairs(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        ArrayList<ArrayList> successorTemp;
        while (true){
            successorTemp = problem.game.getSuccessors(current.state);
            neighborTemp =problem.game.getBestSuccessor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(2));
            for(int i = 0;i<successorTemp.size();i++){
                ArrayList stateTemp = problem.game.moveOneStep(successorTemp,i);
                if((int) stateTemp.get(2)<current.value){
                    neighbor = new Node((char[][])stateTemp.get(0),(int) stateTemp.get(1),(int) stateTemp.get(2));
                    break;
                }
            }

            if(current.value<=neighbor.value){
                return current.state;
            }
            current = neighbor;
        }
    }


    public char[][] simulatedAnnealing(EightPuzzle  problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.manhattanCost(initialState));
        Node neighbor;
        ArrayList tempNeighbor;
        while (true){
//            clearScreen();
//            System.out.println(problem.gameGenerator.printGame(current.state));


            int T = current.value;
            if(T == 0){
                return current.state;
            }
            tempNeighbor = problem.game.randomMove(current.state);
            neighbor = new Node((char[][]) tempNeighbor.get(0),(int) tempNeighbor.get(1),(int) tempNeighbor.get(3));
            int deltaE = current.value - neighbor.value;
            if(deltaE > 0){
                current = neighbor;
            }else {
                double targetProb = Math.exp((double) deltaE/ (double) T);
                double prob = Math.random();
                if(prob>targetProb){
                    current = neighbor;
                }

            }
        }
    }
    public char[][] simulatedAnnealing(EightQueens  problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.attackingPairs(initialState));
        Node neighbor;
        ArrayList tempNeighbor;
        while (true){
            //clearScreen();
            //System.out.println(problem.gameGenerator.printGame(current.state));
            int T = current.value;
            if(T == 0){
                return current.state;
            }
            tempNeighbor = problem.game.randomMove(current.state);
            neighbor = new Node((char[][]) tempNeighbor.get(0),(int) tempNeighbor.get(1),(int) tempNeighbor.get(2));
            int deltaE = current.value - neighbor.value;
            if(deltaE > 0){
                current = neighbor;
            }else {
                double targetProb = Math.exp((double) deltaE/ (double) T);
                double prob = Math.random();
                if(prob>targetProb){
                    current = neighbor;
                }

            }
        }
    }

    void run() {
        int total = 0;
        int sasolved = 0;
        int fcsolved = 0;
        int simAsolved = 0;
        int attempts = 1000;
        float sawinPercentage;
        float fcwinPercentage;
        float simAwinPercentage;
        long start = System.currentTimeMillis();
        //hill Climbing for 8Puzzle
        for (int i = 0; i < attempts; i++) {
            char[][] tempInitial = eightPuzzle.getStates();
            if (eightPuzzle.isSolved(hillClimbingSteepestAscent(eightPuzzle,tempInitial))) {
                sasolved++;
            }
            if (eightPuzzle.isSolved(hillClimbingFirstChoice(eightPuzzle,tempInitial))) {
                fcsolved++;
            }
            if (eightPuzzle.isSolved(simulatedAnnealing(eightPuzzle,tempInitial))) {
                simAsolved++;
            }

            total++;
        }
        long end = System.currentTimeMillis();
        long durationTime = end - start;
        sawinPercentage = (float) sasolved / (float) total * 100;
        fcwinPercentage = (float) fcsolved / (float) total * 100;
        simAwinPercentage = (float) simAsolved / (float) total * 100;
        System.out.println("=======================Statistics========================");
        System.out.printf("                       For %d Attempts                    \n", attempts);
        System.out.println("              Random Restart Hill Climbing               ");
        System.out.println("=========================================================");
        System.out.println("  Algorithm           : Hill Climbing                    ");
        System.out.println("  Problem             : 8Puzzle                          ");
        System.out.printf( "  Steepest Ascent     : %%%f                             \n", sawinPercentage);
        System.out.printf( "  First Choice        : %%%f                             \n", fcwinPercentage);
        System.out.printf( "  Simulated Annealing : %%%f                             \n", simAwinPercentage);
        System.out.printf( "  Execution time      : %d ms                            \n", durationTime);
        System.out.println("=========================================================");


        total = 0;
        sasolved = 0;
        fcsolved = 0;
        simAsolved = 0;
        attempts = 100;
        start = System.currentTimeMillis();
        //hill Climbing for 8Puzzle
        for (int i = 0; i < attempts; i++) {
            char[][] tempInitial = eightQueens.getState();
            if (eightQueens.isSolved(hillClimbingSteepestAscent(eightQueens,tempInitial))) {
                sasolved++;
            }
            if (eightQueens.isSolved(hillClimbingFirstChoice(eightQueens,tempInitial))) {
                fcsolved++;
            }
            if (eightQueens.isSolved(simulatedAnnealing(eightQueens,tempInitial))) {
                simAsolved++;
            }

            total++;
        }
        end = System.currentTimeMillis();
        durationTime = end - start;
        sawinPercentage = (float) sasolved / (float) total * 100;
        fcwinPercentage = (float) fcsolved / (float) total * 100;
        simAwinPercentage = (float) simAsolved / (float) total * 100;
        System.out.println("=======================Statistics========================");
        System.out.printf("                       For %d Attempts                    \n", attempts);
        System.out.println("              Random Restart Hill Climbing               ");
        System.out.println("=========================================================");
        System.out.println("  Algorithm           : Hill Climbing                    ");
        System.out.println("  Problem             : 8Queens                          ");
        System.out.printf( "  Steepest Ascent     : %%%f                             \n", sawinPercentage);
        System.out.printf( "  First Choice        : %%%f                             \n", fcwinPercentage);
        System.out.printf( "  Simulated Annealing : %%%f                             \n", simAwinPercentage);
        System.out.printf( "  Execution time      : %d ms                            \n", durationTime);
        System.out.println("=========================================================");








    }



    private void clearScreen(){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 60*1000; i++) // Default Height of cmd is 300 and Default width is 80
            System.out.print("\b"); // Pr

    }
}

