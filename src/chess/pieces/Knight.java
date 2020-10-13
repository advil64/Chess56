package chess.pieces;

import chess.Chess;

public class Knight extends Chess {
	String id = "";
	String color = "";
	
	public Knight(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
	//method to check if move is valid
	public boolean isValid(int[] start, int[] dest) {
		/*knight has special move cases */
		
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
		//knight movement
		if((dest_i == (start_i-2) && dest_j == (start_j-1)) || (dest_i == (start_i-2) && dest_j == (start_j+1))
				|| (dest_i == (start_i-1) && dest_j == (start_j-2)) || (dest_i == (start_i-1) && dest_j == (start_j+2))
				|| (dest_i == (start_i+1) && dest_j == (start_j-2)) || (dest_i == (start_i+1) && dest_j == (start_j+2))
				|| (dest_i == (start_i+2) && dest_j == (start_j-1)) || (dest_i == (start_i+2) && dest_j == (start_j+1))) {
			return true;
		}
		return false;
	}
}
