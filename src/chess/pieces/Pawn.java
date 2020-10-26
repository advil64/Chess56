/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
package chess.pieces;

import chess.Chess;
/**
 * This class is used to create a Pawn piece object, it extends the Chess class to inherit and override some methods
 */
public class Pawn extends Chess{
	/**
	 * This field is to used identify the Pawn piece on the chess board
	 * @field id - value of id
	 */
	String id = "";
	
	/**
	 * This field is used to identify the color of the Pawn piece
	 * @field color - value of color
	 */
	String color = "";
	
	/**
	 * This field is used to indicate if it is pawn's first move
	 * @field first - value of first
	 */
	boolean first = true;
	
	/**
	 * This field is used to indicate if the pawn performed a two-step as the first move
	 * @field two_step - value of two_step
	 */
	boolean two_step = false;
	
	/**
	 * This field is used to indicate the number of moves the pawn is out of its original spot
	 * @field count - value of count
	 */
	int count = 0;
	
	/**
	 * This is the constructor used to create a Pawn Object in the Chess class
	 * @param id - id of the Pawn
	 * @param color - color of the Pawn
	 * @return Pawn - Pawn object
	 */
	public Pawn(String id, String color) {
		this.id = id;
		this.color = color;
	}
	/**
	 * This method returns the id of the Pawn
	 * @return String - id of the Pawn
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * This method return the color of the Pawn
	 * @return String - color of the Pawn
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * This method checks whether a specific pawn piece has made it's first move yet
	 * true = it is the first move for the pawn, false = not the first move for that pawn
	 * @return boolean - returns a boolean indicating if the pawn had moved
	 */
	public boolean isfirstMove() {
		return this.first;
	}
	/**
	 * This method sets the pawn's boolean field, "first"  
	 * @param boo - is the boolean value the pawn will set it's field "first" to
	 */
	public void setPawnFirst(boolean boo) {
		this.first = boo;
	}
	/**
	 * This method sets the pawn's boolean field, "two_step"
	 * @param b - is the boolean value the pawn will set it's field "two_step" to
	 */
	public void setTwoStep(boolean boo) {
		this.two_step = boo;
	}
	/**
	 * This method gets the pawn's boolean field, "two_step", value to see if the pawn had made 
	 * a 2-step move as it's first move
	 * true = performed a 2-step as initial move, false = did not perform the 2-step as it's first move or has not moved yet 
	 * @return boolean - returns the value of the two_step boolean
	 */
	public boolean getTwoStep() {
		return this.two_step;
	}
	/**
	 * This method gets the count of moves that a pawn is out of its original space, which is the count field
	 * This field is used to check if an en passant can occur
	 * @return int - the number of moves in which the a pawn has been out of its original place
	 */
	public int getCount() {
		return this.count;
	}
	/**
	 * This method sets the count field of a pawn
	 * @param i - takes in an int of which we want to set the pawn's field count as
	 */
	public void setCount(int i) {
		this.count = i;
	}
	
	/**
	 * This method return a boolean indicating whether the move made is valid for a Pawn piece
	 * @param start - int array holding starting indexes (0:row, 1:col)
	 * @param dest - int array holding destination indexes (0:row, 1:col)
	 * @return boolean - value of whether the Pawn can make the move
	 */
	public boolean isValid(int[] start, int[] dest) {
		/*
		 * pawn can only move up one space, except in the beginning where it can move up 2 spaces
		 * pawn can move up diagonally if opponent piece is there or performing an en passant
		 * pawn cannot move up if blocked by their own piece or opponent piece
		*/
		
		//start_i represents current row, start_j represents current column
		int start_i = start[0];
		int start_j = start[1];
		//dest_i represents destination row, dest_j represents destination col
		int dest_i = dest[0];
		int dest_j = dest[1];
		
		//check to see it is the first move for that pawn
		if(chess_board[start_i][start_j].isfirstMove() == true) {
			//check to see if it is black or white
			if(chess_board[start_i][start_j].getColor().equals("white")) {
				//moving 2 spaces up
				//check if both spaces ahead are empty
				if((start_j == dest_j && (start_i - dest_i == 2)) 
						&& ((chess_board[start_i-1][start_j].getId().charAt(0) == ' ') || (chess_board[start_i-1][start_j].getId().charAt(0) == '#'))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))) {
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					//set 2-step condition to true indicating it moved 2 spaces in the first move
					chess_board[start_i][start_j].setTwoStep(true);
					return true;
				}
				//moving up 1 space
				if((start_j == dest_j && (start_i - dest_i == 1))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))){
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally, occupying an opponent's piece
				if(((dest_i == start_i-1 && dest_j == start_j-1) || (dest_i == start_i-1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'b') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
			}
			//black piece moves
			else {
				//moving 2 spaces up
				//check if both spaces ahead are empty
				if((start_j == dest_j && (dest_i-start_i == 2)) 
						&& ((chess_board[start_i+1][start_j].getId().charAt(0) == ' ') || (chess_board[start_i+1][start_j].getId().charAt(0) == '#'))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))) {
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					//set 2-step condition to true indicating it moved 2 spaces in the first move
					chess_board[start_i][start_j].setTwoStep(true);
					return true;
				}
				//moving up 1 space
				if((start_j == dest_j && (dest_i-start_i == 1))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))){
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally, occupying an opponent's piece
				if(((dest_i == start_i+1 && dest_j == start_j-1) || (dest_i == start_i+1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'w') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
			}
		}
		//not the first move
		//an en passant can occur here
		else {
			//check to see if it is black or white
			//white's move
			if(chess_board[start_i][start_j].getColor().equals("white")) {
				//moving up 1 space
				if((start_j == dest_j && (start_i - dest_i == 1))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))){
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally
				//occupying an opponent's piece location
				if(((dest_i == start_i-1 && dest_j == start_j-1) || (dest_i == start_i-1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'b') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//performing an en passant
				//check to see if you are moving up left
				if((dest_i == start_i-1 && dest_j == start_j-1) && (chess_board[start_i][start_j-1].getId().equals("bp")) 
						&& chess_board[start_i][start_j-1].getCount() == 1 && chess_board[start_i][start_j-1].getTwoStep() == true) {
					
					return true;
				}
				//check to see if you are moving up right
				if((dest_i == start_i-1 && dest_j == start_j+1) && (chess_board[start_i][start_j+1].getId().equals("bp")) 
						&& chess_board[start_i][start_j+1].getCount() == 1 && chess_board[start_i][start_j+1].getTwoStep() == true) {
					
					return true;
				}
				
			}
			//black's move
			else {
				//moving up 1 space
				if((start_j == dest_j && (dest_i-start_i == 1))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))){
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally
				//occupying an opponent's piece location
				if(((dest_i == start_i+1 && dest_j == start_j-1) || (dest_i == start_i+1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'w') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					//chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//performing an en passant
				//check to see if you are moving up down left
				if((dest_i == start_i+1 && dest_j == start_j-1) && (chess_board[start_i][start_j-1].getId().equals("wp")) 
						&& chess_board[start_i][start_j-1].getCount() == 1 && chess_board[start_i][start_j-1].getTwoStep() == true) {
					
					return true;
				}
				//check to see if you are moving down right
				if((dest_i == start_i+1 && dest_j == start_j+1) && (chess_board[start_i][start_j+1].getId().equals("wp")) 
						&& chess_board[start_i][start_j+1].getCount() == 1 && chess_board[start_i][start_j+1].getTwoStep() == true) {
					
					return true;
				}
			}
		}
		return false;
	}
}
