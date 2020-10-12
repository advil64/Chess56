package chess.pieces;

import chess.Chess;

public class Rook extends Chess{
	String id = "";
	String color = "";
	
	public Rook(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
}
