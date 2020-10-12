package chess.pieces;

import chess.Chess;

public class Empty extends Chess{
	String id = "";
	String color = "";
	
	public Empty(String id, String color) {
		this.id = id;
		this.color = color;
	}
	public String getId() {
		return this.id;
	}

}
