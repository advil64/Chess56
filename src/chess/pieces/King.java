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
		return this.id + "";
	}
	
	//TODO method to check if board is valid
}
