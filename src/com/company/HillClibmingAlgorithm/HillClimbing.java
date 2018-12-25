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
    LogFile logFile = new LogFile();

    public HillClimbing(EightPuzzle eightPuzzle, EightQueens eightQueens) {
        this.eightPuzzle = eightPuzzle;
        this.eightQueens = eightQueens;
        run();
    }

    public ArrayList hillClimbingSteepestAscent(EightPuzzle problem,char[][] initialState){
        System.out.println(gameGenerator.printGame(initialState));
        Node current = new Node(initialState,-1,problem.heuristic.manhattanCost(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        int cost = 0;
        ArrayList out = new ArrayList();
        while (true){
            neighborTemp =problem.game.getBestNeighbor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(3));
            if(current.value<=neighbor.value){
                out.add(current.state);
                out.add(cost);
               return out;
            }
            current = neighbor;
            cost++;


        }
    }
    public ArrayList hillClimbingSteepestAscent(EightQueens problem,char[][] initialState){
        System.out.println(gameGenerator.printGame(initialState));
        Node current = new Node(initialState,-1,problem.heuristic.attackingPairs(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        int cost = 0;
        ArrayList out = new ArrayList();
        while (true){
            neighborTemp =problem.game.getBestSuccessor(problem.game.getSuccessors(current.state));
            neighbor = new Node((char[][])neighborTemp.get(0),(int) neighborTemp.get(1),(int) neighborTemp.get(2));
            if(current.value<=neighbor.value){
                out.add(current.state);
                out.add(cost);
                return out;
            }
            current = neighbor;
            cost++;
        }
    }


    public ArrayList hillClimbingFirstChoice(EightPuzzle problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.manhattanCost(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        ArrayList<ArrayList> successorTemp;
        int cost = 0;
        ArrayList out = new ArrayList();
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
                out.add(current.state);
                out.add(cost);
                return out;
            }
            current = neighbor;
            cost++;


        }
    }
    public ArrayList hillClimbingFirstChoice(EightQueens problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.attackingPairs(initialState));
        Node neighbor;
        ArrayList neighborTemp;
        ArrayList<ArrayList> successorTemp;
        int cost = 0;
        ArrayList out = new ArrayList();
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
                out.add(current.state);
                out.add(cost);
                return out;
            }
            current = neighbor;
            cost++;
        }
    }


    public ArrayList simulatedAnnealing(EightPuzzle  problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.manhattanCost(initialState));
        Node neighbor;
        ArrayList tempNeighbor;
        int cost = 0;
        ArrayList out = new ArrayList();
        while (true){
//            clearScreen();
//            System.out.println(problem.gameGenerator.printGame(current.state));


            int T = current.value;
            if(T == 0){
                out.add(current.state);
                out.add(cost);
                return out;
            }
            tempNeighbor = problem.game.randomMove(current.state);
            neighbor = new Node((char[][]) tempNeighbor.get(0),(int) tempNeighbor.get(1),(int) tempNeighbor.get(3));
            int deltaE = current.value - neighbor.value;
            if(deltaE > 0){
                current = neighbor;
                cost++;
            }else {
                double targetProb = Math.exp((double) deltaE/ (double) T);
                double prob = Math.random();
                if(prob>targetProb){
                    current = neighbor;
                    cost++;
                }

            }
        }
    }
    public ArrayList simulatedAnnealing(EightQueens  problem,char[][] initialState){
        Node current = new Node(initialState,-1,problem.heuristic.attackingPairs(initialState));
        Node neighbor;
        ArrayList tempNeighbor;
        int cost = 0;
        ArrayList out = new ArrayList();
        while (true){
            //clearScreen();
            //System.out.println(problem.gameGenerator.printGame(current.state));
            int T = current.value;
            if(T == 0){
                out.add(current.state);
                out.add(cost);
                return out;
            }
            tempNeighbor = problem.game.randomMove(current.state);
            neighbor = new Node((char[][]) tempNeighbor.get(0),(int) tempNeighbor.get(1),(int) tempNeighbor.get(2));
            int deltaE = current.value - neighbor.value;
            if(deltaE > 0){
                current = neighbor;
                cost++;
            }else {
                double targetProb = Math.exp((double) deltaE/ (double) T);
                double prob = Math.random();
                if(prob>targetProb){
                    current = neighbor;
                    cost++;
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
        ArrayList stater;
        int sacost=0;
        int fccost=0;
        int simAcost=0;
        //hill Climbing for 8Puzzle
        logFile.writeln(logFile.steepestAscent8puzzle,"a=[\n");
        logFile.writeln(logFile.firstChoice8puzzle,"b=[\n");
        logFile.writeln(logFile.simulatedAnnealing8puzzle,"c=[\n");
        for (int i = 0; i < attempts; i++) {
            char[][] tempInitial = eightPuzzle.getStates();
            stater = hillClimbingSteepestAscent(eightPuzzle,tempInitial);
            if (eightPuzzle.isSolved((char[][]) stater.get(0))) {
                sasolved++;
                sacost +=(int) stater.get(1);
            }
            logFile.writeln(logFile.steepestAscent8puzzle,String.format("%d %d\n",i,(int) stater.get(1)));

            stater = hillClimbingFirstChoice(eightPuzzle,tempInitial);
            if (eightPuzzle.isSolved((char[][]) stater.get(0))) {
                fcsolved++;
                fccost +=(int) stater.get(1);
            }
            logFile.writeln(logFile.firstChoice8puzzle,String.format("%d %d\n",i,(int) stater.get(1)));

            stater = simulatedAnnealing(eightPuzzle,tempInitial);
            if (eightPuzzle.isSolved((char[][]) stater.get(0))) {
                simAsolved++;
                simAcost +=(int) stater.get(1);
            }
            logFile.writeln(logFile.simulatedAnnealing8puzzle,String.format("%d %d\n",i,(int) stater.get(1)));


            total++;
        }
        logFile.writeln(logFile.steepestAscent8puzzle,"];");
        logFile.writeln(logFile.simulatedAnnealing8puzzle,"];");
        logFile.writeln(logFile.firstChoice8puzzle,"];");

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
        System.out.printf( "  Steepest Ascent Cost:   %f                             \n", (float)sacost/(float)sasolved);
        System.out.printf( "  First Choice        : %%%f                             \n", fcwinPercentage);
        System.out.printf( "  First Choice Cost   :   %f                             \n", (float)fccost/(float)fcsolved);
        System.out.printf( "  Simulated Annealing : %%%f                             \n", simAwinPercentage);
        System.out.printf( "  SA Cost             :   %f                             \n", (float)simAcost/(float)simAsolved);
        System.out.printf( "  Execution time      : %d ms                            \n", durationTime);
        System.out.println("=========================================================");


        total = 0;
        sasolved = 0;
        fcsolved = 0;
        simAsolved = 0;
        attempts = 100;
        start = System.currentTimeMillis();
        sacost=0;
        fccost=0;
        simAcost=0;
        //hill Climbing for 8Puzzle
        logFile.writeln(logFile.steepestAscent8queens,"d=[\n");
        logFile.writeln(logFile.firstChoice8queens,"f=[\n");
        logFile.writeln(logFile.simulatedAnnealing8queens,"e=[\n");
        for (int i = 0; i < attempts; i++) {
            char[][] tempInitial = eightQueens.getState();
            stater = hillClimbingSteepestAscent(eightQueens,tempInitial);
            if (eightQueens.isSolved((char[][]) stater.get(0))) {
                sasolved++;
                sacost +=(int) stater.get(1);
            }
            logFile.writeln(logFile.steepestAscent8queens,String.format("%d %d\n",i,(int) stater.get(1)));
            stater = hillClimbingFirstChoice(eightQueens,tempInitial);
            if (eightQueens.isSolved((char[][]) stater.get(0))) {
                fcsolved++;
                fccost +=(int) stater.get(1);
            }
            logFile.writeln(logFile.firstChoice8queens,String.format("%d %d\n",i,(int) stater.get(1)));
            stater = simulatedAnnealing(eightQueens,tempInitial);
            if (eightQueens.isSolved((char[][]) stater.get(0))) {
                simAsolved++;
                simAcost +=(int) stater.get(1);
            }
            logFile.writeln(logFile.simulatedAnnealing8queens,String.format("%d %d\n",i,(int) stater.get(1)));

            total++;
        }
        logFile.writeln(logFile.steepestAscent8queens,"];");
        logFile.writeln(logFile.simulatedAnnealing8queens,"];");
        logFile.writeln(logFile.firstChoice8queens,"];");
        try {
            logFile.outfilefc.close();
            logFile.outfilesimA.close();
            logFile.outfilest.close();
            logFile.outfilefcq.close();
            logFile.outfilesimAq.close();
            logFile.outfilestq.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        System.out.printf( "  Steepest Ascent Cost:   %f                             \n", (float)sacost/(float)sasolved);
        System.out.printf( "  First Choice        : %%%f                             \n", fcwinPercentage);
        System.out.printf( "  First Choice Cost   :   %f                             \n", (float)fccost/(float)fcsolved);
        System.out.printf( "  Simulated Annealing : %%%f                             \n", simAwinPercentage);
        System.out.printf( "  SA Cost             :   %f                             \n", (float)simAcost/(float)simAsolved);
        System.out.printf( "  Execution time      : %d ms                            \n", durationTime);
        System.out.println("=========================================================");



    }


}

