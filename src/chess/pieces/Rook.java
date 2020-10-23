package chess.pieces;

import chess.Chess;

public class Rook extends Chess{
	String id = "";
	String color = "";
	boolean moved = false;
	
	public Rook(String id, String color, boolean moved) {
		this.id = id;
		this.color = color;
		this.moved = moved;
	}
	public String getId() {
		return this.id;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	public boolean getMoved() {
		return this.moved;
	}
	//method to check if move is valid
	public boolean isValid(int[] start, int[] dest) {
		/*rook can only move up/down or left/right any number of spaces */
		
		//start_i represents current row, start_j represents current column
		int start_i = start[0];
		int start_j = start[1];
		//dest_i represents destination row, dest_j represents destination col
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
		return false;
	}
}
