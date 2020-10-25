/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
package chess.pieces;

import chess.Chess;
/**
 * This class is used to create a Empty object, it extends the Chess class to inherit and override methods
 */
public class Empty extends Chess{
	/**
	 * This field is to used identify the Empty spot on the chess board
	 * @field id - value of id
	 */
	String id = "";
	
	/**
	 * This field is used to identify the color of the Empty spot
	 * @field color - value of color
	 */
	String color = "";
	
	/**
	 * This is the constructor used to create a Empty Object in the Chess class
	 * @param id - id of the Empty spot
	 * @param color - color of the Empty spot
	 * @return Empty - Empty object
	 */
	public Empty(String id, String color) {
		this.id = id;
		this.color = color;
	}
	
	/**
	 * This method returns the id of the Empty spot
	 * @return String - id of the Empty spot
	 */
	public String getId() {
		return this.id;
	}

}
