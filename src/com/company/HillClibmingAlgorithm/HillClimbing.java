package com.company.HillClibmingAlgorithm;

import com.company.EightPuzzle.EightPuzzle;
import com.company.EightPuzzle.GameGenerator;

import java.util.ArrayList;

public class HillClimbing {
    EightPuzzle eightPuzzle;

    public HillClimbing(EightPuzzle eightPuzzle) {
        this.eightPuzzle = eightPuzzle;
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

    void run(){
        int total = 0;
        int solved = 0;
        int attempts = 1000;
        float winPercentage;
        for(int i=0;i<attempts;i++){
            if(eightPuzzle.isSolved(hillClimbing(eightPuzzle))){
                solved++;
            }
            total++;
        }
        winPercentage =(float) solved/ (float) total *100;
        System.out.println("=======================Statistics===================");
        System.out.printf( "                    For %d Attempts                 \n",attempts);
        System.out.println("====================================================");
        System.out.printf( "     Win Percentage : %%%f                          \n",winPercentage,total,solved);
    }
}
