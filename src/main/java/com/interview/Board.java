package com.interview;

public class Board {
	int size;
    int[][] grid ;

    public Board(int size) {
    	grid = new int[size][size];
    	this.size = size;
    }
    public int[][] getGrid() {
        return grid;
    }
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setGrid(int[][] grid) {
		this.grid = grid;
	}
	
	public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
