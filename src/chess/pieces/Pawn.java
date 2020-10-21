package chess.pieces;

import chess.Chess;

public class Pawn extends Chess{
	String id = "";
	String color = "";
	boolean first = true; //boolean used to indicate if it is pawn's first move
	boolean two_step = false; //boolean used to indicate if pawn performed a two-step as the first move
	int count = 0;
	
	
	public Pawn(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
	public String getColor() {
		return this.color;
	}
	public boolean isfirstMove() {
		return this.first;
	}
	public void setPawnFirst(boolean boo) {
		this.first = boo;
	}
	public void setTwoStep(boolean boo) {
		this.two_step = boo;
	}
	public boolean getTwoStep() {
		return this.two_step;
	}
	public int getCount() {
		return this.count;
	}
	public void setCount(int i) {
		this.count = i;
	}
	
	//method to check if move is valid
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
					chess_board[start_i][start_j].setPawnFirst(false);
					//set 2-step condition to true indicating it moved 2 spaces in the first move
					chess_board[start_i][start_j].setTwoStep(true);
					return true;
				}
				//moving up 1 space
				if((start_j == dest_j && (start_i - dest_i == 1))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))){
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally, occupying an opponent's piece
				if(((dest_i == start_i-1 && dest_j == start_j-1) || (dest_i == start_i-1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'b') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					chess_board[start_i][start_j].setPawnFirst(false);
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
					chess_board[start_i][start_j].setPawnFirst(false);
					//set 2-step condition to true indicating it moved 2 spaces in the first move
					chess_board[start_i][start_j].setTwoStep(true);
					return true;
				}
				//moving up 1 space
				if((start_j == dest_j && (dest_i-start_i == 1))
						&& ((chess_board[dest_i][dest_j].getId().charAt(0) == ' ') || (chess_board[dest_i][dest_j].getId().charAt(0) == '#'))){
					
					//set first move condition to false indicating it can't move 2 spaces anymore
					chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally, occupying an opponent's piece
				if(((dest_i == start_i+1 && dest_j == start_j-1) || (dest_i == start_i+1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'w') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					chess_board[start_i][start_j].setPawnFirst(false);
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
					chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally
				//occupying an opponent's piece location
				if(((dest_i == start_i-1 && dest_j == start_j-1) || (dest_i == start_i-1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'b') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					chess_board[start_i][start_j].setPawnFirst(false);
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
					chess_board[start_i][start_j].setPawnFirst(false);
					return true;
				}
				//moving diagonally
				//occupying an opponent's piece location
				if(((dest_i == start_i+1 && dest_j == start_j-1) || (dest_i == start_i+1 && dest_j == start_j+1))
						&& chess_board[dest_i][dest_j].getId().charAt(0) == 'w') {
					//set first move condition to false indicating it can't move 2 spaces anymore
					chess_board[start_i][start_j].setPawnFirst(false);
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
