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
		/*queen can move any number of squares in a straight line 
		- either vertically, horizontally or diagonally */
		
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
		if(start_j == dest_j && start_i != dest_j) {
			return true;
		}
		//movement left/right
		if(start_i == dest_i && start_j != dest_j) {
			return true;
		}
		//movement diagonal
		if(Math.abs(start_i-dest_i) == Math.abs(start_j-dest_j)) {
			return true;
		}
		return false;
	}
}
