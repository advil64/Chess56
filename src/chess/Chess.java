/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */
package chess;

//TODO get rid of this line after testing
import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import chess.pieces.Bishop;
import chess.pieces.Empty;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

/**
 * This is the main class named Chess which is used to run the main program
 */
public class Chess {
	
	/**
	 * @field chess_board - 2D 8x8 Object array of type Chess
	 * This field is initializing the size of the chess board to be of object type Chess which is an 8x8 matrix
	 */
	public static Chess[][] chess_board = new Chess[8][8];
	
	/**
	 * This method is called to initialize the board in the beginning of the program by placing all chess pieces in their correct original position
	 * in the chess_board 2D object array we created earlier
	 */
	public static void initBoard() {
		chess_board[0][0] = new Rook("bR", "black", false);
		chess_board[0][1] = new Knight("bN", "black");
		chess_board[0][2] = new Bishop("bB", "black");
		chess_board[0][3] = new Queen("bQ", "black");
		chess_board[0][4] = new King("bK", "black", false);
		chess_board[0][5] = new Bishop("bB", "black");
		chess_board[0][6] = new Knight("bN", "black");
		chess_board[0][7] = new Rook("bR", "black", false);
		chess_board[1][0] = new Pawn("bp", "black");
		chess_board[1][1] = new Pawn("bp", "black");
		chess_board[1][2] = new Pawn("bp", "black");
		chess_board[1][3] = new Pawn("bp", "black");
		chess_board[1][4] = new Pawn("bp", "black");
		chess_board[1][5] = new Pawn("bp", "black");
		chess_board[1][6] = new Pawn("bp", "black");
		chess_board[1][7] = new Pawn("bp", "black");
		
		for(int i=2; i<6; i++) {
			for(int j=0; j<chess_board[0].length; j++) {
				if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)) {
					chess_board[i][j] = new Empty("  ", "white");
				}
				if((i%2==0 && j%2!=0) || (i%2!=0 && j%2==0)) {
					chess_board[i][j] = new Empty("##", "black");
				}
			}
		}
		
		chess_board[7][0] = new Rook("wR", "white", false);
		chess_board[7][1] = new Knight("wN", "white");
		chess_board[7][2] = new Bishop("wB", "white");
		chess_board[7][3] = new Queen("wQ", "white");
		chess_board[7][4] = new King("wK", "white", false);
		chess_board[7][5] = new Bishop("wB", "white");
		chess_board[7][6] = new Knight("wN", "white");
		chess_board[7][7] = new Rook("wR", "white", false);
		chess_board[6][0] = new Pawn("wp", "white");
		chess_board[6][1] = new Pawn("wp", "white");
		chess_board[6][2] = new Pawn("wp", "white");
		chess_board[6][3] = new Pawn("wp", "white");
		chess_board[6][4] = new Pawn("wp", "white");
		chess_board[6][5] = new Pawn("wp", "white");
		chess_board[6][6] = new Pawn("wp", "white");
		chess_board[6][7] = new Pawn("wp", "white");
		
	}
	/**
	 * This method is overridden in the chess pieces' classes to return their ID
	 * @return String - returns the ID of the chess piece the method is called upon
	 */
	public String getId() {
		return "";
	}
	/**
	 * This method is overridden in the chess pieces' classes to return their color (white/black)
	 * @return String - return the color of the chess piece the method is called upon
	 */
	public String getColor() {
		return "";
	}
	/**
	 * This method is overridden in the chess pieces' classes to return a boolean to indicate whether the move for that particular piece is valid
	 * false = invalid, true = valid
	 * @param start - an integer array that holds the row and column starting position of a chess piece in the 0th and 1st index respectively
	 * @param destination - an integer array that holds row and columns destination position of a chess piece in the 0th and 1st index respectively
	 * @return boolean - returns a boolean indicating if the move is valid
	 */
	public boolean isValid(int[] start, int[] destination) {
		return false;
	}
	/**
	 * This method is overridden in the pawn class to check whether a specific pawn piece has made it's first move yet
	 * true = it is the first move for the pawn, false = not the first move for that pawn
	 * @return boolean - returns a boolean indicating if the pawn had moved
	 */
	public boolean isfirstMove() {
		return true;
	}
	/**
	 * This method is overridden in the pawn class to set the pawn's boolean field, "first"  
	 * @param boo - is the boolean value the pawn will set it's field "first" to
	 */
	public void setPawnFirst(boolean boo) {
	}
	/**
	 * This method is overridden in the pawn class to set the pawn's boolean field, "two_step"
	 * @param b - is the boolean value the pawn will set it's field "two_step" to
	 */
	public void setTwoStep(boolean b) {	
	}
	/**
	 * This method is overridden in the pawn class to get the pawn's boolean field, "two_step", value to see if the pawn had made 
	 * a 2-step move as it's first move
	 * true = performed a 2-step as initial move, false = did not perform the 2-step as it's first move or has not moved yet 
	 * @return boolean - returns the value of the two_step boolean
	 */
	public boolean getTwoStep() {
		return false;
	}
	/**
	 * This method is overridden in the pawn class to get the count of moves that a pawn is out of its original space, which is the count field
	 * This field is used to check if an en passant can occur
	 * @return int - the number of moves in which the a pawn has been out of its original place
	 */
	public int getCount() {
		return 0;
	}
	/**
	 * This method is overridden in the pawn class to set the count field of a pawn
	 * @param i - takes in an int of which we want to set the pawn's field count as
	 */
	public void setCount(int i) {
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return boolean
	 */
	//only used in king class
	public boolean isCheck(int x, int y) {
		return false;
	}
	/**
	 * This method is overridden in the King class to set the boolean field moved, which indicates whether the king has moved
	 * This field is used for the purpose of castling
	 * @param moved - takes in a boolean to set the field moved in the King's class
	 */
	public void setMoved(boolean moved) {
	}
	/**
	 * This method is overridden in the King class to return the value of the field moved
	 * @return boolean - return the value of the King's field move
	 */
	public boolean getMoved() {
		return false;
	}

	/**
	 * TODO Write this javadoc
	 * @return
	 */
	public ArrayList getSpots(int[] attackerPos, int[] kingPos) {
		return null;
	}
	
	/**
	 * This method is called to print the chess_board
	 */
	public static void printBoard() {
		int[] arr = {8,7,6,5,4,3,2,1};
		char[] arr2 = {'a','b','c','d','e','f','g','h'};
		for(int i=0; i<chess_board.length; i++) {
			for(int j=0; j<chess_board[0].length; j++) {
				System.out.print(chess_board[i][j].getId() + " ");
			}
			System.out.print(arr[i]);
			System.out.println();
		}
		System.out.print(" "+ arr2[0]);
		for(int i=1; i<arr.length; i++) {
			System.out.print("  " + arr2[i]);
		}
		System.out.println();
		System.out.println();
		
	}
	
	/**
	 * This method takes in an array start_indexes which holds the row index and column index starting position at the 0th and 1st index respectively, 
	 * and takes in an array destination_indexes which holds the row index and column index ending position at the 0th and 1st index respectively, 
	 * and takes in a boolean used to set the king's and rook's moved boolean field. This method essentially updates the board by moving the pieces to their
	 * requested position by the player
	 * @param start_indexes - int array which holds the starting indexes of a chess piece
	 * @param destination_indexes - int array which holds the destination indexes of a chess piece
	 * @param move - boolean used to set the moved variable for a King or Rook chess piece
	 */
	public static void updateBoard(int[] start_indexes, int[] destination_indexes, String move) {
		//check to see if a promotion is occurring
		//check to see if pawn reaches the end index
		//if the pawn reaches the end index automatically set pawn to queen if promotion type is not specified
		//white pawn
		if(move.length() == 5 && chess_board[start_indexes[0]][start_indexes[1]].getId().equals("wp") && destination_indexes[0] == 0) {
			//set pawn destination to queen
			chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("wQ", "white");
			//set original spot to empty
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//pawn reaches end and promotion type is specified
		if(move.length() == 7 && chess_board[start_indexes[0]][start_indexes[1]].getId().equals("wp") && destination_indexes[0] == 0) {
			switch(move.charAt((6))) {
				case 'R':
					//set pawn destination to rook
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Rook("wR", "white", true);
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'N':
					//set pawn destination to knight
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Knight("wN", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'B':
					//set pawn destination to bishop
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Bishop("wB", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'Q':
					//set pawn destination to queen
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("wQ", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				default:
					//set pawn destination to queen
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("wQ", "white");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
			}
			return;
		}
		//black pawn promotion
		if(move.length() == 5 && chess_board[start_indexes[0]][start_indexes[1]].getId().equals("bp") && destination_indexes[0] == 7) {
			//set pawn destination to queen
			chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("bQ", "white");
			//set original spot to empty
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//pawn reaches end and promotion type is specified
		if(move.length() == 7 && chess_board[start_indexes[0]][start_indexes[1]].getId().equals("bp") && destination_indexes[0] == 7) {
			switch(move.charAt((6))) {
				case 'R':
					//set pawn destination to rook
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Rook("bR", "black", true);
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'N':
					//set pawn destination to knight
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Knight("bN", "black");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'B':
					//set pawn destination to bishop
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Bishop("bB", "black");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				case 'Q':
					//set pawn destination to queen
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("bQ", "black");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
				default:
					//set pawn destination to queen
					chess_board[destination_indexes[0]][destination_indexes[1]] = new Queen("bQ", "black");
					//set original spot to empty
					if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
					}
					if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
						chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
					}
					break;
			}
			return;
		}
		
		//regular updating the board (non-promotion)
		chess_board[destination_indexes[0]][destination_indexes[1]] = chess_board[start_indexes[0]][start_indexes[1]];
		
		//if you're moving a king or rook make sure their moved boolean is set to true to indicate they moved out of their original position
		//used for castling
		if(chess_board[destination_indexes[0]][destination_indexes[1]].getId().charAt(1) == 'K' 
				|| chess_board[destination_indexes[0]][destination_indexes[1]].getId().charAt(1) == 'R') {
			chess_board[destination_indexes[0]][destination_indexes[1]].setMoved(true);
		}
		
			
		//every time we update the board we must increase the count of the pawn to indicate the time out of it's original place
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(chess_board[i][j].getId().equals("wp") && (i != 6)) {
					chess_board[i][j].setCount(chess_board[i][j].getCount()+1);
				}
				if(chess_board[i][j].getId().equals("bp") && (i != 1)) {
					chess_board[i][j].setCount(chess_board[i][j].getCount()+1);
				}
			}
		}
		//check to see if we are performing an en passant
		int start_i = start_indexes[0];
		int start_j = start_indexes[1];
		int dest_i = destination_indexes[0];
		int dest_j = destination_indexes[1];
		//white is moving up left
		if(chess_board[start_i][start_j].getId().equals("wp") && (dest_i == start_i-1 && dest_j == start_j-1) 
				&& (chess_board[start_i][start_j-1].getId().equals("bp"))) {
			//remove the black piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j-1%2==0) || (start_i%2!=0 && start_j-1%2!=0)) {
				chess_board[start_i][start_j-1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j-1%2!=0) || (start_i%2!=0 && start_j-1%2==0)) {
				chess_board[start_i][start_j-1] = new Empty("  ", "white");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//white is moving up right
		if(chess_board[start_i][start_j].getId().equals("wp") && (dest_i == start_i-1 && dest_j == start_j+1) 
				&& (chess_board[start_i][start_j+1].getId().equals("bp"))) {
			//remove the black piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j+1%2==0) || (start_i%2!=0 && start_j+1%2!=0)) {
				chess_board[start_i][start_j+1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j+1%2!=0) || (start_i%2!=0 && start_j+1%2==0)) {
				chess_board[start_i][start_j+1] = new Empty("##", "black");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//black is moving down right
		if(chess_board[start_i][start_j].getId().equals("bp") && (dest_i == start_i+1 && dest_j == start_j+1) 
				&& (chess_board[start_i][start_j+1].getId().equals("wp"))) {
			//remove the white piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j+1%2==0) || (start_i%2!=0 && start_j+1%2!=0)) {
				chess_board[start_i][start_j+1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j+1%2!=0) || (start_i%2!=0 && start_j+1%2==0)) {
				chess_board[start_i][start_j+1] = new Empty("##", "black");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//black is moving down left
		if(chess_board[start_i][start_j].getId().equals("bp") && (dest_i == start_i+1 && dest_j == start_j-1) 
				&& (chess_board[start_i][start_j-1].getId().equals("wp"))) {
			//remove the white piece and replace with empty and make start index empty
			if((start_i%2==0 && start_j-1%2==0) || (start_i%2!=0 && start_j-1%2!=0)) {
				chess_board[start_i][start_j-1] = new Empty("  ", "white");
			}
			if((start_i%2==0 && start_j-1%2!=0) || (start_i%2!=0 && start_j-1%2==0)) {
				chess_board[start_i][start_j-1] = new Empty("##", "black");
			}
			//set start index to blank
			if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
			}
			if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
				chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
			}
			return;
		}
		//non-en passant making start index blank
		if((start_indexes[0]%2==0 && start_indexes[1]%2==0) || (start_indexes[0]%2!=0 && start_indexes[1]%2!=0)) {
			chess_board[start_indexes[0]][start_indexes[1]] = new Empty("  ", "white");
		}
		if((start_indexes[0]%2==0 && start_indexes[1]%2!=0) || (start_indexes[0]%2!=0 && start_indexes[1]%2==0)) {
			chess_board[start_indexes[0]][start_indexes[1]] = new Empty("##", "black");
		}
	}

	//traverses the board to check if the board is in a check state
	private static boolean check(boolean turn) {
		//first find the king
		Chess temp;
		Chess black_king = chess_board[0][4];
		int[] bpos = new int[]{0,4};
		Chess white_king = chess_board[7][4];
		int[] wpos = new int[]{7,4};
		Chess attacker = null;
		int[] attackerPos = new int[]{0,0};
		ArrayList<int[]> validSpots = null;
		for(int i = 0; i < chess_board.length; i++){
			for(int j = 0; j < chess_board[0].length; j++){
				temp = chess_board[i][j];
				if(temp.getId().equals("bK")){
					black_king = temp;
					bpos = new int[]{i,j};
				}
				if(temp.getId().equals("wK")){
					white_king = temp;
					wpos = new int[]{i,j};
				}
			}
		}
		//check if either of the kings are currently in check
		if(black_king.isCheck(bpos[0], bpos[1])){
			System.out.println("Check");
			int[][] options = {new int[]{-1,1}, new int[]{0,1}, new int[]{1,1}, new int[]{-1,0}, new int[]{1,0}, new int[]{-1,-1}, new int[]{0,-1}, new int[]{1,-1}};
			//try to make all possible moves
			for (int[] i : options){
				if(black_king.isValid(bpos, new int[]{bpos[0]+i[0], bpos[1]+i[1]}) && !black_king.occupy(bpos, new int[]{bpos[0]+i[0], bpos[1]+i[1]})){
					return false;
				}
			}
			//now we check if our team mate can come to our rescue, first find the attacker
			for(int i = 0; i < chess_board.length; i++){
				for(int j = 0; j < chess_board[0].length; j++){
					temp = chess_board[i][j];
					if(temp.getId().charAt(1) != 'K' && temp.getId().charAt(0) == 'w' && temp.isValid(new int[]{i,j}, bpos)){
						attacker = chess_board[i][j];
						attackerPos = new int[]{i,j};
					}
				}
			}
			//get spots between the attacker and black king
			validSpots = attacker.getSpots(attackerPos, bpos);
			//loop through the spots returned and check if any teammates can move there
			if(validSpots != null){
				for(int[] x : validSpots){
					for(int i = 0; i < chess_board.length; i++) {
						for (int j = 0; j < chess_board[0].length; j++) {
							temp = chess_board[i][j];
							if(temp.getId().charAt(1) != 'K' && temp.getId().charAt(0) == 'b' && temp.isValid(new int[]{i,j}, x)){
								if(temp.getId().charAt(1) == 'P'){
									temp.setPawnFirst(true);
								}
								return false;
							}
						}
					}
				}
			}
			//lastly loop through the board and check if any teammates can take out the attacker
			for(int i = 0; i < chess_board.length; i++) {
				for (int j = 0; j < chess_board[0].length; j++) {
					temp = chess_board[i][j];
					if(temp.getId().charAt(1) != 'K' && temp.getId().charAt(0) == 'b' && temp.isValid(new int[]{i,j}, attackerPos)){
						if(temp.getId().charAt(1) == 'P'){
							temp.setPawnFirst(true);
						}
						return false;
					}
				}
			}

			System.out.println("Checkmate");
			System.out.println("White wins");
			return true;

		} else if(white_king.isCheck(wpos[0], wpos[1])){
			System.out.println("Check");
			int[][] options = {new int[]{-1,1}, new int[]{0,1}, new int[]{1,1}, new int[]{-1,0}, new int[]{1,0}, new int[]{-1,-1}, new int[]{0,-1}, new int[]{1,-1}};
			//try to make all possible moves
			for (int[] i : options){
				if(white_king.isValid(wpos, new int[]{wpos[0]+i[0], wpos[1]+i[1]}) && !white_king.occupy(wpos, new int[]{wpos[0]+i[0], wpos[1]+i[1]})){
					return false;
				}
			}
			//now we check if our team mate can come to our rescue, first find the attacker
			for(int i = 0; i < chess_board.length; i++){
				for(int j = 0; j < chess_board[0].length; j++){
					temp = chess_board[i][j];
					if(temp.getId().charAt(1) != 'K' && temp.getId().charAt(0) == 'b' && temp.isValid(new int[]{i,j}, wpos)){
						attacker = chess_board[i][j];
						attackerPos = new int[]{i,j};
					}
				}
			}
			//get spots between the attacker and black king
			validSpots = attacker.getSpots(attackerPos, wpos);
			//loop through the spots returned and check if any teammates can move there
			if(validSpots != null){
				for(int[] x : validSpots){
					for(int i = 0; i < chess_board.length; i++) {
						for (int j = 0; j < chess_board[0].length; j++) {
							temp = chess_board[i][j];
							if(temp.getId().charAt(1) != 'K' && temp.getId().charAt(0) == 'w' && temp.isValid(new int[]{i,j}, x)){
								if(temp.getId().charAt(1) == 'P'){
									temp.setPawnFirst(true);
								}
								return false;
							}
						}
					}
				}
			}
			//lastly loop through the board and check if any teammates can take out the attacker
			for(int i = 0; i < chess_board.length; i++) {
				for (int j = 0; j < chess_board[0].length; j++) {
					temp = chess_board[i][j];
					if(temp.getId().charAt(1) != 'K' && temp.getId().charAt(0) == 'w' && temp.isValid(new int[]{i,j}, attackerPos)){
						if(temp.getId().charAt(1) == 'P'){
							temp.setPawnFirst(true);
						}
						return false;
					}
				}
			}

			System.out.println("Checkmate");
			System.out.println("Black wins");
			return true;
		}
		return false;
	}
	
	/**
	 * This method takes in a string (position on board), and returns the position in the 2D array
	 * @param str - String which holds a position on the board (Ex. "e2")
	 * @return int array - an array that holds the row and column index at the 0th index and 1st index
	 */
	public static int[] find_indexes(String str) {
		int[] arr = new int[2];
		switch(Character.getNumericValue(str.charAt(1))) {
		case 1:
			arr[0] = 7;
			break;
		case 2:
			arr[0] = 6;
			break;
		case 3:
			arr[0] = 5;
			break;
		case 4:
			arr[0] = 4;
			break;
		case 5:
			arr[0] = 3;
			break;
		case 6:
			arr[0] = 2;
			break;
		case 7:
			arr[0] = 1;
			break;
		case 8:
			arr[0] = 0;
			break;
		default:
			arr[0] = 8;
		}
		switch(str.charAt(0)) {
		case 'a':
			arr[1] = 0;
			break;
		case 'b':
			arr[1] = 1;
			break;
		case 'c':
			arr[1] = 2;
			break;
		case 'd':
			arr[1] = 3;
			break;
		case 'e':
			arr[1] = 4;
			break;
		case 'f':
			arr[1] = 5;
			break;
		case 'g':
			arr[1] = 6;
			break;
		case 'h':
			arr[1] = 7;
			break;
		default:
			arr[1] = 8;
		}
		return arr;
	}
	
	/**
	 * This method checks to see if a destination is occupied by a team piece
	 * true = occupied by a team piece, false = not occupied by a team piece 
	 * @param start - indexes for the starting position of a piece (0:row, 1:column)
	 * @param destination - indexes for the ending position of a piece (0:row, 1:column)
	 * @return - boolean to indicate if the destination is occupied by a team piece
	 */
	//this method checks to see if the spot is occupied by its own team piece
	public static boolean occupy(int[] start, int[] destination) {
		//check to see if destination is occupied by team chess piece
		if(chess_board[start[0]][start[1]].getId().charAt(0) == chess_board[destination[0]][destination[1]].getId().charAt(0)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This is the main method which is used to run the program
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		initBoard();
		printBoard();

		// TODO get rid of this line after testing
		File moves = new File("/Users/advithchegu/Desktop/Random Code/chess56/moves.txt");
		Scanner scan = new Scanner(moves);
		boolean check = true;
		int[] start_indexes = new int[2];
		int[] destination_indexes = new int[2];
		boolean draw = false;
		while(true) {
			//white's turn
			if(check == true) {
				System.out.print("White's move: ");
				//Scanner scan = new Scanner(System.in); TODO change back after testing
				String move = scan.nextLine();
				//checking to see if player resigned
				if(move.equals("resign")) {
					System.out.println("Black wins");
					return;
				}
				//check to see if game ends in draw
				if(draw == true && move.equals("draw")) {
					return;
				}
				//reset the draw boolean
				draw = false;
				String start = move.substring(0,2);
				String destination = move.substring(3,5);
				start_indexes = find_indexes(start);
				destination_indexes = find_indexes(destination);
				//checking to see if player is making a move from a white piece
				if(chess_board[start_indexes[0]][start_indexes[1]].getId().charAt(0) != 'w') {
					System.out.println("Illegal move, try again");
					continue;
				}
				//checking if indexes are out of bounds
				if(start_indexes[0] == 8 || start_indexes[1] == 8 || destination_indexes[0] == 8 || destination_indexes[1] == 8) {
					System.out.println("Illegal move, try again");
					continue;
				}
				
				/////////////////////////////////     CASTLING      //////////////////////////////////////////////////////////////////
				if(chess_board[start_indexes[0]][start_indexes[1]].getId().charAt(1) == 'K') {
					//checking if castling right and king is not in check (white)
					if(start_indexes[0] == 7 && start_indexes[1] == 4 && destination_indexes[0] == 7 && destination_indexes[1] == 6
							&& chess_board[7][7].getId().equals("wR") && chess_board[7][4].isCheck(start_indexes[0],start_indexes[1]) == false) {
						//check to see if king and rook did not move
						if(chess_board[start_indexes[0]][start_indexes[1]].getMoved() == false && chess_board[7][7].getMoved() == false) {
							//check to see if all positions are empty
							if((chess_board[7][5].getId().charAt(0) == ' ') && (chess_board[7][6].getId().charAt(0) == '#')) {
								chess_board[7][5] = chess_board[7][4];
								chess_board[7][6] = chess_board[7][4];
								if(chess_board[7][4].isCheck(7,5) == false && chess_board[7][4].isCheck(7,6) == false) {
									//update the board accordingly
									chess_board[7][6] = chess_board[7][4];
									chess_board[7][5] = chess_board[7][7];
									chess_board[7][4] = new Empty("##", "black");
									chess_board[7][7] = new Empty("  ", "white");
									check = false;
									System.out.println();
									printBoard();
									continue;
								}
								chess_board[7][5] = new Empty("  ", "white");
								chess_board[7][6] = new Empty("##", "black");
								System.out.println("Illegal move, try again");
								continue;
							}
							System.out.println("Illegal move, try again");
							continue;
						}
						System.out.println("Illegal move, try again");
						continue;
					}
					//checking if castling right and king is not in check (white)
					if(start_indexes[0] == 7 && start_indexes[1] == 4 && destination_indexes[0] == 7 && destination_indexes[1] == 1
							&& chess_board[7][0].getId().equals("wR") && chess_board[7][4].isCheck(start_indexes[0],start_indexes[1]) == false) {
						//check to see if king and rook did not move
						if(chess_board[start_indexes[0]][start_indexes[1]].getMoved() == false && chess_board[7][0].getMoved() == false) {
							//check to see if all positions are empty
							if((chess_board[7][3].getId().charAt(0) == ' ') && (chess_board[7][2].getId().charAt(0) == '#') && (chess_board[7][1].getId().charAt(0) == ' ')) {
								chess_board[7][3] = chess_board[7][4];
								chess_board[7][2] = chess_board[7][4];
								chess_board[7][1] = chess_board[7][4];
								if(chess_board[7][4].isCheck(7,3) == false && chess_board[7][4].isCheck(7,2) == false && chess_board[7][4].isCheck(7,1) == false) {
									//update the board accordingly
									chess_board[7][1] = chess_board[7][4];
									chess_board[7][2] = chess_board[7][0];
									chess_board[7][4] = new Empty("##", "black");
									chess_board[7][3] = new Empty("  ", "white");
									chess_board[7][0] = new Empty("##", "white");
									check = false;
									System.out.println();
									printBoard();
									continue;
								}
								chess_board[7][3] = new Empty("  ", "white");
								chess_board[7][2] = new Empty("##", "black");
								chess_board[7][1] = new Empty("  ", "white");
								System.out.println("Illegal move, try again");
								continue;
							}
							System.out.println("Illegal move, try again");
							continue;
						}
						System.out.println("Illegal move, try again");
						continue;
					}
				}
			////////////////////////////////     CASTLING      //////////////////////////////////////////////////////////////////
				
				
				boolean occupy = occupy(start_indexes,destination_indexes);
				//checks if the move is valid for the piece
				if(!chess_board[start_indexes[0]][start_indexes[1]].isValid(start_indexes,destination_indexes) || occupy == true) {
					System.out.println("Illegal move, try again");
				}
				//if valid move, update board and set to black's move
				else{
					if(move.length() > 5) {
						//checking to see if user wants to request a draw
						if(draw == false && move.substring(6).equals("draw?")) {
							draw = true;
						}
					}
					//update the board
					updateBoard(start_indexes, destination_indexes,move);
					//print the board
					System.out.println();
					printBoard();
					//setting to black's turn
					check = false;
				}
			}
			//check in between turns
			if(check(check)){
				//this is a checkmate
				break;
			}
			//black's turn
			if(check == false) {
				System.out.print("Black's move: ");
				String move = scan.nextLine();
				//checking to see if player resigned
				if(move.equals("resign")) {
					System.out.println("White wins");
					return;
				}
				//check to see if game ends in draw
				if(draw == true && move.equals("draw")) {
					return;
				}
				//reset the draw boolean
				draw = false;
				String start = move.substring(0,2);
				String destination = move.substring(3);
				start_indexes = find_indexes(start);
				destination_indexes = find_indexes(destination);
				//checking to see if player is making a move on a white piece
				if(chess_board[start_indexes[0]][start_indexes[1]].getId().charAt(0) != 'b') {
					System.out.println("Illegal move, try again");
					continue;
				}
				//checking if indexes are out of bounds
				if(start_indexes[0] == 8 || start_indexes[1] == 8 || destination_indexes[0] == 8 || destination_indexes[1] == 8) {
					System.out.println("Illegal move, try again");
					continue;
				}
				
			/////////////////////////////////     CASTLING      //////////////////////////////////////////////////////////////////
				//checking if castling right and king is not in check (black)
				if(chess_board[start_indexes[0]][start_indexes[1]].getId().charAt(1) == 'K') {
					if(start_indexes[0] == 0 && start_indexes[1] == 4 && destination_indexes[0] == 0 && destination_indexes[1] == 6
							&& chess_board[0][7].getId().equals("bR") && chess_board[0][4].isCheck(start_indexes[0],start_indexes[1]) == false) {
						//check to see if king and rook did not move
						if(chess_board[start_indexes[0]][start_indexes[1]].getMoved() == false && chess_board[0][7].getMoved() == false) {
							//check to see if all positions are empty
							if((chess_board[0][5].getId().charAt(0) == '#') && (chess_board[0][6].getId().charAt(0) == ' ')) {
								chess_board[0][5] = chess_board[0][4];
								chess_board[0][6] = chess_board[0][4];
								if(chess_board[0][4].isCheck(0,5) == false && chess_board[0][4].isCheck(0,6) == false) {
									//update the board accordingly
									chess_board[0][6] = chess_board[0][4];
									chess_board[0][5] = chess_board[0][7];
									chess_board[0][4] = new Empty("##", "black");
									chess_board[0][7] = new Empty("  ", "white");
									check = true;
									System.out.println();
									printBoard();
									continue;
								}
								chess_board[0][5] = new Empty("##", "black");
								chess_board[0][6] = new Empty("  ", "white");
								System.out.println("Illegal move, try again");
								continue;
							}
							System.out.println("Illegal move, try again");
							continue;
						}
						System.out.println("Illegal move, try again");
						continue;
					}
					//checking if castling left and king is not in check (black)
					if(start_indexes[0] == 0 && start_indexes[1] == 4 && destination_indexes[0] == 0 && destination_indexes[1] == 1
							&& chess_board[0][0].getId().equals("bR") && chess_board[0][4].isCheck(start_indexes[0],start_indexes[1]) == false) {
						//check to see if king and rook did not move
						if(chess_board[start_indexes[0]][start_indexes[1]].getMoved() == false && chess_board[0][0].getMoved() == false) {
							//check to see if all positions are empty
							if((chess_board[0][3].getId().charAt(0) == '#') && (chess_board[0][2].getId().charAt(0) == ' ') && (chess_board[0][1].getId().charAt(0) == '#')) {
								chess_board[0][3] = chess_board[0][4];
								chess_board[0][2] = chess_board[0][4];
								chess_board[0][1] = chess_board[0][4];
								if(chess_board[0][4].isCheck(0,3) == false && chess_board[0][4].isCheck(0,2) == false && chess_board[0][4].isCheck(0,1) == false) {
									//update the board accordingly
									chess_board[0][1] = chess_board[0][4];
									chess_board[0][2] = chess_board[0][0];
									chess_board[0][4] = new Empty("  ", "white");
									chess_board[0][3] = new Empty("##", "white");
									chess_board[0][0] = new Empty("  ", "white");
									check = true;
									System.out.println();
									printBoard();
									continue;
								}
								chess_board[0][3] = new Empty("##", "black");
								chess_board[0][2] = new Empty("  ", "white");
								chess_board[0][1] = new Empty("##", "black");
								System.out.println("Illegal move, try again");
								continue;
							}
							System.out.println("Illegal move, try again");
							continue;
						}
						System.out.println("Illegal move, try again");
						continue;
					}
				}
				/////////////////////////////////     CASTLING      //////////////////////////////////////////////////////////////////

				
				boolean occupy = occupy(start_indexes,destination_indexes);
				//checks if the move is valid for the piece
				if(!chess_board[start_indexes[0]][start_indexes[1]].isValid(start_indexes,destination_indexes) || occupy == true) {
					System.out.println("Illegal move, try again");
				}
				//if valid move, update board and set to white's move
				else{
					//check to see if user wants to request a draw
					if(move.length()> 5) {
						if(draw == false && move.substring(6).equals("draw?") ) {
							draw = true;
						}
					}
					//update the board
					updateBoard(start_indexes, destination_indexes, move);
					//print board
					System.out.println();
					printBoard();
					//setting to white's turn
					check = true;
				}
			}
			if(check(check)){
				//this is a checkmate
				break;
			}

		}

	}

}
