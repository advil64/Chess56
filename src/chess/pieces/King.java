/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
package chess.pieces;

import chess.Chess;

/**
 * This class is used to create a King piece object, it extends the Chess class to inherit and override some methods
 */
public class King extends Chess{
	/**
	 * This field is to used identify the King piece on the chess board
	 * @field id - value of id
	 */
	String id = "";
	/**
	 * This field is used to identify the color of the King piece
	 * @field color - value of color
	 */
	String color = "";
	/**
	 * This field is used to identify whether the king has moved out of its original position
	 * @field moved - value of moved
	 */
	boolean moved = false;
	
	/**
	 * This is the constructor used to create a King Object in the Chess class
	 * @param id - id of the King
	 * @param color - color of the King
	 * @param moved - boolean to indicate if the king has moved
	 */
	public King(String id, String color, boolean moved) {
		this.id = id;
		this.color = color;
		this.moved = moved;
	}
	/**
	 * This method returns the id of the king
	 * @return String - id of the King
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * This method return the color of the King
	 * @return String - color of the King
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * This method takes in a boolean and set's the moved field of the King object
	 * @param moved - boolean value to be set as the moved field
	 */
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	/**
	 * This method returns the boolean of the moved field for the King object 
	 * @return boolean - value of moved field
	 */
	public boolean getMoved() {
		return this.moved;
	}
	
	/**
	 * This method return a boolean indicating whether the move made is valid for a King piece
	 * @param start - int array holding starting indexes (0:row, 1:col)
	 * @param dest - int array holding destination indexes (0:row, 1:col)
	 * @return boolean - value of whether the King can make the move
	 */
	public boolean isValid(int[] start, int[] dest) {
		/*king can only move a space in every direction if their own piece
		is not already occupying the space, or put itself in check */
		
		//start_i represents current row, start_j represents current column
		int start_i = start[0];
		int start_j = start[1];
		//dest_i represents destination row, dest_j represents destination col
		int dest_i = dest[0];
		int dest_j = dest[1];
		boolean isValid = false;
		
		//check if move goes out of bounds
		if(dest_i > 7 || dest_i < 0) {
			return false;
		}
		if(dest_j > 7 || dest_j < 0) {
			return false;
		}
		
		//row
		if(dest_i == (start_i+1) && dest_j == start_j || ((dest_i == (start_i-1) && dest_j == start_j))) {
			isValid = true;
		}
		//column
		if(dest_j == (start_j+1) && dest_i == start_i || (dest_j == (start_j-1) && dest_i == start_i)) {
			isValid = true;
		}
		//diagonal
		if((dest_j == (start_j+1) && dest_i == (start_i+1)) || ((dest_j == (start_j-1) && dest_i == (start_i+1))) 
				|| (dest_j == (start_j+1) && dest_i == (start_i-1)) || (dest_j == (start_j-1) && dest_i == (start_i-1))) {
			isValid = true;
		}
		//now check if the king is moving into a check position, this is also illegal
		if(isValid && !isCheck(dest_i, dest_j)){
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
				if(temp.getId().charAt(1) != 'K' && temp.isValid(new int[]{i,j}, new int[]{x,y}) && temp.getId().charAt(0) != this.getId().charAt(0)){
					return true;
				}
			}
		}
		return false;
	}
	
}
