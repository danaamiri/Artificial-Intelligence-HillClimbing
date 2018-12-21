package com.company.EightPuzzle;

public class GameGenerator {
    public String printGame(char[][] game) {
        String generatedGame = "";
        generatedGame = generatedGame + "-------------\n";

        for(int i = 0; i < 3; ++i) {
            generatedGame = generatedGame + "| ";

            for(int j = 0; j < 3; ++j) {
                if (game[i][j] != '0') {
                    generatedGame = generatedGame + game[i][j];
                } else {
                    generatedGame = generatedGame + " ";
                }

                if (j != 2) {
                    generatedGame = generatedGame + " | ";
                }
            }

            generatedGame = generatedGame + " |\n";
        }

        generatedGame = generatedGame + "-------------\n\n";
        return generatedGame;
    }
}
