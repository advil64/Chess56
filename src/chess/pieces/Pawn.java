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
}
