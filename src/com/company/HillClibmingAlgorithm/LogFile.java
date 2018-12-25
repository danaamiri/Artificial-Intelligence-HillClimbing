package com.company.HillClibmingAlgorithm;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile {
    public String steepestAscent8puzzle = "logfiles/steepestAscent8Puzzle.m";
    public String simulatedAnnealing8puzzle = "logfiles/simulateAnnealing8Puzzle.m";
    public String firstChoice8puzzle = "logfiles/firstChoice8Puzzle.m";
    public String steepestAscent8queens = "logfiles/steepestAscent8Queens.m";
    public String simulatedAnnealing8queens = "logfiles/simulateAnnealing8Queens.m";
    public String firstChoice8queens = "logfiles/firstChoice8Queens.m";

    FileWriter outfilest;
    FileWriter outfilesimA;
    FileWriter outfilefc;
    FileWriter outfilestq;
    FileWriter outfilesimAq;
    FileWriter outfilefcq;

    {
        try {
            outfilest = new FileWriter(steepestAscent8puzzle);
            outfilesimA = new FileWriter(simulatedAnnealing8puzzle);
            outfilefc = new FileWriter(firstChoice8puzzle);
            outfilestq = new FileWriter(steepestAscent8queens);
            outfilesimAq = new FileWriter(simulatedAnnealing8queens);
            outfilefcq = new FileWriter(firstChoice8queens);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;
    public void writeln(String address, String input){

        try {
            switch (address){
                case "logfiles/steepestAscent8Puzzle.m":
                    outfilest.write(input);
                    break;
                case "logfiles/simulateAnnealing8Puzzle.m":
                    outfilesimA.write(input);
                    break;
                case "logfiles/firstChoice8Puzzle.m":
                    outfilefc.write(input);
                    break;
                case "logfiles/steepestAscent8Queens.m":
                    outfilestq.write(input);
                    break;
                case "logfiles/simulateAnnealing8Queens.m":
                    outfilesimAq.write(input);
                    break;
                case "logfiles/firstChoice8Queens.m":
                    outfilefcq.write(input);
                    break;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
