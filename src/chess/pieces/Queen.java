package chess.pieces;

import chess.Chess;

import java.util.ArrayList;

/**
 * This class is used to create a Queen piece object, it extends the Chess class to inherit and override some methods
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
public class Queen extends Chess {
	/**
	 * This field is to used identify the Queen piece on the chess board
	 */
	String id;
	
	/**
	 * This field is used to identify the color of the Queen piece
	 */
	String color;
	
	/**
	 * This is the constructor used to create a Queen Object in the Chess class
	 * @param id - id of the Queen
	 * @param color - color of the Queen
	 */
	public Queen(String id, String color) {
		this.id = id;
		this.color = color;
	}
	/**
	 * This method returns the id of the Queen
	 * @return String - id of the Queen
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * This method return a boolean indicating whether the move made is valid for a Queen piece
	 * @param start - int array holding starting indexes (0:row, 1:col)
	 * @param dest - int array holding destination indexes (0:row, 1:col)
	 * @return boolean - value of whether the Queen can make the move
	 */
	public boolean isValid(int[] start, int[] dest) {
		/*
		 * queen can move any number of squares in a straight line either vertically, horizontally or diagonally 
		 * queen cannot jump over their own pieces
		*/
		
		//start i and j equals start index
		int start_i = start[0];
		int start_j = start[1];
		//dest i and j equals end index
		int dest_i = dest[0];
		int dest_j = dest[1];

		//check if move goes out of bounds or stays put
		if(dest_i > 7 || dest_i < 0) {
			return false;
		}
		if(dest_j > 7 || dest_j < 0) {
			return false;
		}
		if(start_i == dest_i && start_j == dest_j){
			return false;
		}
		//movement up/down
		if(start_j == dest_j && start_i != dest_i) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_i < dest_i) {
				for(int i=start_i+1; i<dest_i; i++) {
					if((chess_board[i][start_j].getId().charAt(0) != ' ') && (chess_board[i][start_j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			else {
				for(int i=start_i-1; i>dest_i; i--) {
					if((chess_board[i][start_j].getId().charAt(0) != ' ') && (chess_board[i][start_j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			return true;
		}
		//movement left/right
		if(start_i == dest_i && start_j != dest_j) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_j < dest_j) {
				for(int j=start_j+1; j<dest_j; j++) {
					if((chess_board[start_i][j].getId().charAt(0) != ' ') && (chess_board[start_i][j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			else {
				for(int j=start_j-1; j>dest_j; j--) {
					if((chess_board[start_i][j].getId().charAt(0) != ' ') && (chess_board[start_i][j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			return true;
		}
		//movement diagonal
		if(Math.abs(start_i-dest_i) == Math.abs(start_j-dest_j)) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			//moving up right
			if(start_i>dest_i && start_j<dest_j) {
				for(int i=start_i-1, j=start_j+1; i>dest_i && j<dest_j; i--, j++) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')){
						return false;
					}
				}
			}
			//moving up left
			if(start_i>dest_i && start_j>dest_j) {
				for(int i=start_i-1, j=start_j-1; i>dest_i && j>dest_j; i--, j--) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')) {
						return false;
					}
				}
			}
			//moving down right
			if(start_i<dest_i && start_j>dest_j) {
				for(int i=start_i+1, j=start_j-1; i<dest_i && j>dest_j; i++, j--) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')){
						return false;
					}
				}
			}
			//moving down left
			if(start_i<dest_i && start_j<dest_j) {
				for(int i=start_i+1, j=start_j+1; i<dest_i && j<dest_j; i++, j++) {
					if((chess_board[i][j].getId().charAt(0) != ' ') && (chess_board[i][j].getId().charAt(0) != '#')){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * In the event that king is in check, this method returns the spots between attacker and king
	 * @param attackerPos - Position of the attacking piece
	 * @param kingPos - Position of the King piece
	 * @return ArrayList - arraylist of spots between attacker and king
	 */
	public ArrayList<int[]> getSpots(int[] attackerPos, int[] kingPos) {
		ArrayList<int[]> spots = new ArrayList<>();
		//start_i represents current row, start_j represents current column
		int start_i = attackerPos[0];
		int start_j = attackerPos[1];
		//dest_i represents destination row, dest_j represents destination col
		int dest_i = kingPos[0];
		int dest_j = kingPos[1];
		//movement up/down
		if(start_j == dest_j && start_i != dest_i) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_i < dest_i) {
				for(int i=start_i+1; i<dest_i; i++) {
					spots.add(new int[]{i,dest_j});
				}
			}
			else {
				for(int i=start_i-1; i>dest_i; i--) {
					spots.add(new int[]{i,dest_j});
				}
			}
		}
		//movement left/right
		if(start_i == dest_i && start_j != dest_j) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			if(start_j < dest_j) {
				for(int j=start_j+1; j<dest_j; j++) {
					spots.add(new int[]{dest_i,j});
				}
			}
			else {
				for(int j=start_j-1; j>dest_j; j--) {
					spots.add(new int[]{dest_i,j});
				}
			}
		}
		//movement diagonal
		if(Math.abs(start_i-dest_i) == Math.abs(start_j-dest_j)) {
			//checking to see whether you are jumping over a piece (not allowed to jump over pieces)
			//moving up right
			if(start_i>dest_i && start_j<dest_j) {
				for(int i=start_i-1, j=start_j+1; i>dest_i && j<dest_j; i--, j++) {
					spots.add(new int[]{i,j});
				}
			}
			//moving up left
			if(start_i>dest_i && start_j>dest_j) {
				for(int i=start_i-1, j=start_j-1; i>dest_i && j>dest_j; i--, j--) {
					spots.add(new int[]{i,j});
				}
			}
			//moving down right
			if(start_i<dest_i && start_j>dest_j) {
				for(int i=start_i+1, j=start_j-1; i<dest_i && j>dest_j; i++, j--) {
					spots.add(new int[]{i,j});
				}
			}
			//moving down left
			if(start_i<dest_i && start_j<dest_j) {
				for(int i=start_i+1, j=start_j+1; i<dest_i && j<dest_j; i++, j++) {
					spots.add(new int[]{i,j});
				}
			}
		}
		return spots;
	}
	/**
	 * This method checks to see if the move will put or keep the King in check
	 * @param start - starting indexes of piece
	 * @param dest - ending indexes of piece
	 * @return boolean - true if King results in being in check
	 */
	public boolean move_makes_check(int[] start, int[] dest) {
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
		Chess temp2 = chess_board[dest[0]][dest[1]];
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
					chess_board[dest[0]][dest[1]] = temp2;
					return true;
				}
			}
		}
		//reset the move
		chess_board[start[0]][start[1]] = chess_board[dest[0]][dest[1]];
		chess_board[dest[0]][dest[1]] = temp2;
		return false;
	}
}
