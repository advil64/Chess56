package chess.pieces;

import chess.Chess;

public class Queen extends Chess {
	String id = "";
	String color = "";
	
	public Queen(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
	
	//method to check if move is valid
	public boolean isValid(int[] start, int[] dest) {
		/*
		 * queen can move any number of squares in a straight line either vertically, horizontally or diagonally 
		 * queen cannot jump over their own pieces
		*/
		
		//start i and j equals start index
		int start_i = start[0];
		int start_j = start[1];
		//dest i and j equals end index
		int dest_i = dest[0];
		int dest_j = dest[1];
		
		//check if move goes out of bounds
		if(dest_i > 7 || dest_i < 0) {
			return false;
		}
		if(dest_j > 7 || dest_j < 0) {
			return false;
		}
		//movement up/down
		if(start_j == dest_j && start_i != dest_i) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_i < dest_i) {
				for(int i=start_i+1; i<dest_i; i++) {
					if((chess_board[i][start_j].getId().charAt(0) != ' ') && (chess_board[i][start_j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			else {
				for(int i=start_i-1; i>dest_i; i--) {
					if((chess_board[i][start_j].getId().charAt(0) != ' ') && (chess_board[i][start_j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			return true;
		}
		//movement left/right
		if(start_i == dest_i && start_j != dest_j) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_j < dest_j) {
				for(int j=start_j+1; j<dest_j; j++) {
					if((chess_board[start_i][j].getId().charAt(0) != ' ') && (chess_board[start_i][j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			else {
				for(int j=start_j-1; j>dest_j; j--) {
					if((chess_board[start_i][j].getId().charAt(0) != ' ') && (chess_board[start_i][j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			return true;
		}
		//movement diagonal
		if(Math.abs(start_i-dest_i) == Math.abs(start_j-dest_j)) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			//moving up right
			if(start_i>dest_i && start_j<dest_j) {
				for(int i=start_i-1, j=start_j+1; i>dest_i && j<dest_j; i--, j++) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')){
						return false;
					}
				}
			}
			//moving up left
			if(start_i>dest_i && start_j>dest_j) {
				for(int i=start_i-1, j=start_j-1; i>dest_i && j>dest_j; i--, j--) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			//moving down right
			if(start_i<dest_i && start_j>dest_j) {
				for(int i=start_i+1, j=start_j-1; i<dest_i && j>dest_j; i++, j--) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')){
						return false;
					}
				}
			}
			//moving down left
			if(start_i<dest_i && start_j<dest_j) {
				for(int i=start_i+1, j=start_j+1; i<dest_i && j<dest_j; i++, j++) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}
}
