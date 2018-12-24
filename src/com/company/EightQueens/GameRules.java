package com.company.EightQueens;

import java.util.ArrayList;

public class GameRules {
    Tools tools =  new Tools();
    Moves moves = new Moves();
    QueensHeuristic heuristic = new QueensHeuristic();
    GameGenerator gameGenerator = new GameGenerator();
    public ArrayList<ArrayList> getSuccessors(char[][] state){
        char[][] temp = tools.copyState(state);
        ArrayList<int[]> queens = tools.findQueens(temp);
        ArrayList<ArrayList> successors = new ArrayList<>();
        for(int k=0;k<8;k++){
            int[] queenTemp = queens.get(k);
            int ie = queenTemp[0];
            int je = queenTemp[1];
            for(int i=1;i<=8;i++){
                temp = tools.copyState(state);
                int move;
                ArrayList tempState = new ArrayList();
                if(tools.checkMove(temp,ie,je,i)){
                    move = i;
                    switch (i){
                        case 1:
                            tempState.add(moves.n(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 2:
                            tempState.add(moves.e(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 3:
                            tempState.add(moves.s(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 4:
                            tempState.add(moves.w(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 5:
                            tempState.add(moves.ne(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 6:
                            tempState.add(moves.se(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 7:
                            tempState.add(moves.sw(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                        case 8:
                            tempState.add(moves.nw(temp,ie,je));
                            tempState.add(move);
                            tempState.add(heuristic.attackingPairs((char[][]) tempState.get(0)));
                            break;
                    }
                    successors.add(tempState);
                }
            }

        }
        return successors;
    }

    public ArrayList getBestSuccessor(ArrayList<ArrayList> successors){
        ArrayList state;
        int cost = 1000;
        int index = 0;
        for(int i=0;i<successors.size();i++){
            int tempCost = (int) successors.get(i).get(2);
            if(tempCost<cost){
                cost = tempCost;
                index = i;
            }
        }
        state = successors.get(index);
        return state;
    }
}
