package com.company.EightQueens;

import com.company.EightQueens.GameGenerator;
import com.company.EightQueens.StateGenerator;

public class EightQueens {
    private GameGenerator gameGenerator = new GameGenerator();
    private StateGenerator stateGenerator = new StateGenerator();
    public EightQueens() {
        for(int i=0;i<12;i++){
            System.out.println(gameGenerator.printGame(stateGenerator.generateStates().get(i)));
        }
    }
}
