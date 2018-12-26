package com.company.EightQueens;

public class GameGenerator {
    public GameGenerator() {
    }

    public String printGame(char[][] game) {
        String generatedGame = "";
        generatedGame = generatedGame + "-----------------\n";

        for (int i = 0; i < 8; ++i) {
            generatedGame = generatedGame + "|";

            for (int j = 0; j < 8; ++j) {
                if (game[i][j] != '1') {
                    generatedGame = generatedGame + " ";
                } else {
                    generatedGame = generatedGame + "Q";
                }

                if (j != 7) {
                    generatedGame = generatedGame + "|";
                }
            }

            generatedGame = generatedGame + "|\n";
        }

        generatedGame = generatedGame + "-----------------\n\n";
        return generatedGame;
    }
}
