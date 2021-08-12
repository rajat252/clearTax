package com.interview;

public class TicTacToe {
	int boardSize;
    Board board;
    int currentPlayer = 0;
    boolean singlePlayer = false;

    public void init(int boardSize, boolean singlePlayer) {
    	this.boardSize = boardSize;
        this.board = new Board(boardSize);
        this.singlePlayer = singlePlayer;
    }

    public void step(Location location) throws Exception {
    	
        if(board.getGrid()[location.i][location.j]!=-1) {
        	System.out.println("Slot already filled. Please try again");
        	throw new Exception("Slot already filled. Please try again");
        }
        
        board.getGrid()[location.i][location.j] = currentPlayer;
        board.printBoard();
        currentPlayer = currentPlayer == 0 ? 1 : 0;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isSinglePlayer() {
    	return singlePlayer;
    }
    public int getCurrentPlayer() {
    	return currentPlayer;
    }
    
    public int getWinner() {
    	int winner = -1;
    	for(int i = 0; i < boardSize; i++) {
    		
    		int start = board.getGrid()[i][0];
    		winner = start;
            for(int j = 1; j < boardSize; j++) {
            	if(board.getGrid()[i][j]!=start) {
            		winner = -1;
            	}
            }
    	}
    	return winner;
    }
    
    public boolean isFinished() {
    	
    	if(getWinner()!=-1) {
    		System.out.println(getWinner());
    		return true;
    	}
    	
    	for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
            	if(board.getGrid()[i][j] == -1)
                {
                	return false;
                }
            	
            }
        }
    	return true;
    }
}
