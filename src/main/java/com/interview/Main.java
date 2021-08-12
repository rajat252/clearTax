package com.interview;

import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) {
	    TicTacToe ticTacToe = new TicTacToe();
	    int size = 3;
        init(ticTacToe, size);
        while(!ticTacToe.isFinished()) {
        	makeMove(ticTacToe);
        }

        if(ticTacToe.getWinner() > -1) {
            System.out.println("Winner is " + (ticTacToe.getWinner() + 1));
        }
        else {
        	System.out.println("There is no winner");
        }
      
    }
    
    private static void makeMove(TicTacToe ticTacToe) {
    	Location location = getLocation(ticTacToe);
    	try {
        	ticTacToe.step(location);
        }
        catch(Exception e) {
        	makeMove(ticTacToe);
        }
    }
    
    private static Location getLocation(TicTacToe ticTacToe) {
    	Location location;
        if(ticTacToe.currentPlayer == 1 && ticTacToe.singlePlayer) {
            location = IntelligentMoveGenerator.nextMove();
        } else {
        	System.out.println("Make a move for player: "+ticTacToe.currentPlayer);
            location = new Location(readInt(), readInt());
        }
        return location;
    }

    private static void init(TicTacToe ticTacToe, int size) {
        

        System.out.println("Single Player? ");
        if(readInt() == 0) {
            ticTacToe.init(size, false);
        } else {
            ticTacToe.init(size, true);
        }
        Board board = ticTacToe.getBoard();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                board.getGrid()[i][j] = -1;
            }
        }
    }

    private static int readInt() {
    	
        Scanner myInput = new Scanner( System.in );
        return myInput.nextInt();
    }    	
    
}
