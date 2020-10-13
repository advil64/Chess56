package chess.pieces;

import chess.Chess;

public class Pawn extends Chess{
	String id = "";
	String color = "";
	
	public Pawn(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
	//method to check if move is valid
		public boolean isValid(int[] start, int[] dest) {
		/*
		 * pawn can only move up one space, except in the beginning where it can move up 2 spaces
		 * pawn can move up diagonally if opponent piece is there
		 * pawn cannot move up if blocked by their own piece or opponent piece
		*/
		
		//start_i represents current row, start_j represents current column
		int start_i = start[0];
		int start_j = start[1];
		//dest_i represents destination row, dest_j represents destination col
		int dest_i = dest[0];
		int dest_j = dest[1];
		
		return false;
	}
}
