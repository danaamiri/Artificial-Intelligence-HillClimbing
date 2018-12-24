package com.company.EightQueens;

public class Moves {
    Tools tools =  new Tools();

    public char[][] n(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,1)){
            temp[ie-1][je] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }
    public char[][] e(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,2)){
            temp[ie][je+1] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }

    public char[][] s(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,3)){
            temp[ie+1][je] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }


    public char[][] w(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,4)){
            temp[ie][je-1] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }

    public char[][] ne(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,5)){
            temp[ie-1][je+1] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }

    public char[][] se(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,6)){
            temp[ie+1][je+1] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }

    public char[][] sw(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,7)){
            temp[ie+1][je-1] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }

    public char[][] nw(char[][] state, int ie, int je){
        char[][] temp = tools.copyState(state);
        if(tools.checkMove(state,ie,je,8)){
            temp[ie-1][je-1] = '1';
            temp[ie][je] = '0';
        }else{
            System.out.println("This move not allowed");
        }
        return temp;
    }


}
