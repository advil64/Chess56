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

		//now check if the king is moving into a check position, this is also illegal
		if(!isCheck(dest_i, dest_j)){
			return true;
		}
		
		return false;
	}


	public boolean isCheck(int x, int y) {
		//basically loop through the array and check if any other piece can move there
		Chess temp;
		for(int i = 0; i < chess_board.length; i++){
			for(int j = 0; j < chess_board[0].length; j++){
				temp = chess_board[i][j];
				if(!temp.getId().equals(this.id) && temp.isValid(new int[]{i,j}, new int[]{x,y}) && !temp.occupy(new int[]{i,j}, new int[]{x,y}) ){
					return true;
				}
			}
		}
		return false;
	}
}
