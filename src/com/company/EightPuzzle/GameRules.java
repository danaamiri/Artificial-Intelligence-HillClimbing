package com.company.EightPuzzle;

import java.util.ArrayList;

public class GameRules {
    private Moves moves = new Moves();
    private Tools tools = new Tools();
    private PuzzleHeuristic heuristic = new PuzzleHeuristic();
    private GameGenerator gameGenerator = new GameGenerator();


    public ArrayList<ArrayList> getSuccessors(char[][] state){
        ArrayList<ArrayList> successors = new ArrayList<>();
        char move = ' ';
        int[] st = tools.getEmpty(state);
        int ie = st[0];
        int je = st[1];
        int moveCode = 0;
        for(int i =1;i<=4;i++){
            ArrayList temp  = new ArrayList();
            if(tools.checkMoves(state,i,ie,je)){
                switch (i){
                    case 1:
                        move = 'U';
                        moveCode = 1;
                        break;
                    case 2:
                        move = 'R';
                        moveCode = 2;
                        break;
                    case 3:
                        move = 'D';
                        moveCode = 3;
                        break;
                    case 4:
                        move = 'L';
                        moveCode = 4;
                        break;

                }
                switch (i){

                    case 1:
                        temp.add(moves.up(state,st));

                        break;
                    case 2:
                        temp.add(moves.right(state,st));

                        break;
                    case 3:
                        temp.add(moves.down(state,st));

                        break;
                    case 4:
                        temp.add(moves.left(state,st));

                        break;
                }

                temp.add(moveCode);
                temp.add(move);
                temp.add(heuristic.manhattanCost((char[][]) temp.get(0)));
                successors.add(temp);
            }

        }
        return successors;
    }



    public ArrayList getBestNeighbor(ArrayList<ArrayList> states){
        ArrayList state;
        int cost = 1000;
        int index = 0;
        for(int i=0;i<states.size();i++){
            int tempCost = (int) states.get(i).get(3);
            if(tempCost<cost){
                cost = tempCost;
                index = i;
            }
        }
        state = states.get(index);
        return state;

    }

}
