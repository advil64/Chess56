/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
package chess.pieces;

import chess.Chess;

import java.util.ArrayList;

/**
 * This class is used to create a Rook piece object, it extends the Chess class to inherit and override some methods
 */
public class Rook extends Chess{
	/**
	 * This field is to used identify the Rook piece on the chess board
	 * @field id - value of id
	 */
	String id = "";
	/**
	 * This field is used to identify the color of the Rook piece
	 * @field color - value of color
	 */
	String color = "";
	/**
	 * This field is used to identify whether the Rook has moved out of its original position
	 * @field moved - value of moved
	 */
	boolean moved = false;
	/**
	 * This is the constructor used to create a Rook Object in the Chess class
	 * @param id - id of the Rook
	 * @param color - color of the Rook
	 * @param moved - boolean to indicate if the Rook has moved
	 * @return Rook - Rook object
	 */
	public Rook(String id, String color, boolean moved) {
		this.id = id;
		this.color = color;
		this.moved = moved;
	}
	/**
	 * This method returns the id of the Rook
	 * @return String - id of the Rook
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * This method takes in a boolean and set's the moved field of the Rook object
	 * @param moved - boolean value to be set as the moved field
	 */
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	/**
	 * This method returns the boolean of the moved field for the Rook object 
	 * @return boolean - value of moved field
	 */
	public boolean getMoved() {
		return this.moved;
	}
	/**
	 * This method return a boolean indicating whether the move made is valid for a Rook piece
	 * @param start - int array holding starting indexes (0:row, 1:col)
	 * @param dest - int array holding destination indexes (0:row, 1:col)
	 * @return boolean - value of whether the Rook can make the move
	 */
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

	public ArrayList getSpots(int[] attackerPos, int[] kingPos) {
		ArrayList<int[]> spots = new ArrayList<>();
		//start_i represents current row, start_j represents current column
		int start_i = attackerPos[0];
		int start_j = attackerPos[1];
		//dest_i represents destination row, dest_j represents destination col
		int dest_i = kingPos[0];
		int dest_j = kingPos[1];
		//movement up/down
		if(start_j == dest_j && start_i != dest_i) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_i < dest_i) {
				for(int i=start_i+1; i<dest_i; i++) {
					spots.add(new int[]{i,dest_j});
				}
			}
			else {
				for(int i=start_i-1; i>dest_i; i--) {
					spots.add(new int[]{i,dest_j});
				}
			}
		}
		//movement left/right
		if(start_i == dest_i && start_j != dest_j) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_j < dest_j) {
				for(int j=start_j+1; j<dest_j; j++) {
					spots.add(new int[]{dest_i,j});
				}
			}
			else {
				for(int j=start_j-1; j>dest_j; j--) {
					spots.add(new int[]{dest_i,j});
				}
			}
		}
		return spots;
	}
}
