package chess.pieces;

import chess.Chess;

public class Queen extends Chess {
	String id = "";
	String color = "";
	
	public Queen(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}
}
