/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
package chess.pieces;

import chess.Chess;
/**
 * This class is used to create a Knight piece object, it extends the Chess class to inherit and override some methods
 */
public class Knight extends Chess {
	/**
	 * This field is to used identify the Knight piece on the chess board
	 * @field id - value of id
	 */
	
	String id = "";
	/**
	 * This field is used to identify the color of the Knight piece
	 * @field color - value of color
	 */
	String color = "";
	
	/**
	 * This is the constructor used to create a Knight Object in the Chess class
	 * @param id - id of the Knight
	 * @param color - color of the Knight
	 * @return Bishop - Knight object
	 */
	public Knight(String id, String color) {
		this.id = id;
		this.color = color;
	}
	/**
	 * This method returns the id of the Knight
	 * @return String - id of the Knight
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * This method return a boolean indicating whether the move made is valid for a Knight piece
	 * @param start - int array holding starting indexes (0:row, 1:col)
	 * @param dest - int array holding destination indexes (0:row, 1:col)
	 * @return boolean - value of whether the Knight can make the move
	 */
	public boolean isValid(int[] start, int[] dest) {
		/*knight has special move cases */
		
		//start i and j equals start index
		int start_i = start[0];
		int start_j = start[1];
		//dest i and j equals end index
		int dest_i = dest[0];
		int dest_j = dest[1];
		
		//check if move goes out of bounds
		if(dest_i > 7 || dest_i < 0) {
			return false;
		}
		if(dest_j > 7 || dest_j < 0) {
			return false;
		}
		//knight movement
		if((dest_i == (start_i-2) && dest_j == (start_j-1)) || (dest_i == (start_i-2) && dest_j == (start_j+1))
				|| (dest_i == (start_i-1) && dest_j == (start_j-2)) || (dest_i == (start_i-1) && dest_j == (start_j+2))
				|| (dest_i == (start_i+1) && dest_j == (start_j-2)) || (dest_i == (start_i+1) && dest_j == (start_j+2))
				|| (dest_i == (start_i+2) && dest_j == (start_j-1)) || (dest_i == (start_i+2) && dest_j == (start_j+1))) {
			return true;
		}
		return false;
	}
	/**
	 * This method checks to see if the move will put or keep the King in check
	 * @param start - starting indexes of piece
	 * @param dest - ending indexes of piece
	 * @return boolean - true if King results in being in check
	 */
	public boolean move_makes_check(int start[], int dest[]) {
		//obtain the index of the King
		int K_row = 0;
		int K_col = 0;
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(chess_board[i][j].getId().charAt(1) == 'K' && chess_board[i][j].getId().charAt(0) == chess_board[start[0]][start[1]].getId().charAt(0)) {
					K_row = i;
					K_col = j;
				}
			}
		}
		chess_board[dest[0]][dest[1]] = chess_board[start[0]][start[1]];
		if((start[0]%2==0 && start[1]%2==0) || (start[0]%2!=0 && start[1]%2!=0)) {
			chess_board[start[0]][start[1]] = new Empty("  ", "white");
		}
		if((start[0]%2==0 && start[1]%2!=0) || (start[0]%2!=0 && start[1]%2==0)) {
			chess_board[start[0]][start[1]] = new Empty("##", "black");
		}
		//checking to see if the King is still in check after the move
		Chess temp;
		for(int i = 0; i < chess_board.length; i++){
			for(int j = 0; j < chess_board[0].length; j++){
				temp = chess_board[i][j];
				//if a piece can move the King is currently in check
				if(temp.getId().charAt(1) != 'K' && temp.isValid(new int[]{i,j}, new int[]{K_row,K_col}) && temp.getId().charAt(0) != chess_board[dest[0]][dest[1]].getId().charAt(0)){
					//reset the move
					chess_board[start[0]][start[1]] = chess_board[dest[0]][dest[1]];
					if((dest[0]%2==0 && dest[1]%2==0) || (dest[0]%2!=0 && dest[1]%2!=0)) {
						chess_board[dest[0]][dest[1]] = new Empty("  ", "white");
					}
					if((dest[0]%2==0 && dest[1]%2!=0) || (dest[0]%2!=0 && dest[1]%2==0)) {
						chess_board[dest[0]][dest[1]] = new Empty("##", "black");
					}
					return true;
				}
			}
		}
		//reset the move
		chess_board[start[0]][start[1]] = chess_board[dest[0]][dest[1]];
		if((dest[0]%2==0 && dest[1]%2==0) || (dest[0]%2!=0 && dest[1]%2!=0)) {
			chess_board[dest[0]][dest[1]] = new Empty("  ", "white");
		}
		if((dest[0]%2==0 && dest[1]%2!=0) || (dest[0]%2!=0 && dest[1]%2==0)) {
			chess_board[dest[0]][dest[1]] = new Empty("##", "black");
		}
		return false;
	}
}
