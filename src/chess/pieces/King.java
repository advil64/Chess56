package chess.pieces;

import chess.Chess;

public class King extends Chess{
	String id = "";
	String color = "";
	
	public King(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
	public String getColor() {
		return this.color;
	}
	
	//method to check if move is valid
	public boolean isValid(int[] start, int[] dest) {
		/*king can only move a space in every direction if their own piece
		is not already occupying the space, or put itself in check */
		
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
		
		//row
		if(dest_i == (start_i+1) && dest_j == start_j || ((dest_i == (start_i-1) && dest_j == start_j))) {
			return true;
		}
		//column
		if(dest_j == (start_j+1) && dest_i == start_i || (dest_j == (start_j-1) && dest_i == start_i)) {
			return true;
		}
		//diagonal
		if((dest_j == (start_j+1) && dest_i == (start_i+1)) || ((dest_j == (start_j-1) && dest_i == (start_i+1))) 
				|| (dest_j == (start_j+1) && dest_i == (start_i-1)) || (dest_j == (start_j-1) && dest_i == (start_i-1))) {
			return true;
		}
		
		return false;
	}
}
