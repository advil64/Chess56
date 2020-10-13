package chess;

import java.util.Scanner;

import chess.pieces.Bishop;
import chess.pieces.Empty;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import chess.pieces.Rook;

/**
 * 
 * @author Advith Chegu
 * @author Banty Patel
 *
 */

public class Chess {
	
	public static Chess[][] chess_board = new Chess[8][8];
	
	public static void initBoard() {
		chess_board[0][0] = new Rook("bR", "black");
		chess_board[0][1] = new Knight("bN", "black");
		chess_board[0][2] = new Bishop("bB", "black");
		chess_board[0][3] = new Queen("bQ", "black");
		chess_board[0][4] = new King("bK", "black");
		chess_board[0][5] = new Bishop("bB", "black");
		chess_board[0][6] = new Knight("bN", "black");
		chess_board[0][7] = new Rook("bR", "black");
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
		
		chess_board[7][0] = new Rook("wR", "white");
		chess_board[7][1] = new Knight("wN", "white");
		chess_board[7][2] = new Bishop("wB", "white");
		chess_board[7][3] = new Queen("wQ", "white");
		chess_board[7][4] = new King("wK", "white");
		chess_board[7][5] = new Bishop("wB", "white");
		chess_board[7][6] = new Knight("wN", "white");
		chess_board[7][7] = new Rook("wR", "white");
		chess_board[6][0] = new Pawn("wp", "white");
		chess_board[6][1] = new Pawn("wp", "white");
		chess_board[6][2] = new Pawn("wp", "white");
		chess_board[6][3] = new Pawn("wp", "white");
		chess_board[6][4] = new Pawn("wp", "white");
		chess_board[6][5] = new Pawn("wp", "white");
		chess_board[6][6] = new Pawn("wp", "white");
		chess_board[6][7] = new Pawn("wp", "white");
		
	}
	public String getId() {
		return "";
	}
	public String getColor() {
		return "";
	}
	public boolean isValid(int[] start, int[] destination) {
		return true;
	}
	
	public static void printBoard() {
		for(int i=0; i<chess_board.length; i++) {
			for(int j=0; j<chess_board[0].length; j++) {
				System.out.print(chess_board[i][j].getId() + " ");
			}
			System.out.println();
		}
	}
	
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
		}
		return arr;
	}
	
	
	public static boolean occupy(int[] start, int[] destination) {
		//check to see if destination is occupied by team chess piece
		if(chess_board[start[0]][start[1]].getId().charAt(0) == chess_board[destination[0]][destination[1]].getId().charAt(0)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initBoard();
		printBoard();
		
		boolean check = true;
		while(true) {
			//white's turn
			if(check == true) {
				System.out.print("White's move: ");
				Scanner scan = new Scanner(System.in);
				String move = scan.nextLine();
				String start = move.substring(0,2);
				String destination = move.substring(3);
				int[] start_indexes = find_indexes(start);
				int[] destination_indexes = find_indexes(destination);
				boolean occupy = occupy(start_indexes,destination_indexes);
				//checks if the move is valid for the piece
				if(!chess_board[start_indexes[0]][start_indexes[1]].isValid(start_indexes,destination_indexes) || occupy == true) {
					System.out.println("Illegal move, try again");
				}
				//if valid move, set to black's move
				else{
					check = false;
				}
			}
			//black's turn
			if(check == false) {
				System.out.print("Black's move: ");
				Scanner scan = new Scanner(System.in);
				String move = scan.nextLine();
				String start = move.substring(0,2);
				String destination = move.substring(3);
				int[] start_indexes = new int[2];
				start_indexes = find_indexes(start);
				int[] destination_indexes = new int[2];
				destination_indexes = find_indexes(destination);
				boolean occupy = occupy(start_indexes,destination_indexes);
				//checks if the move is valid for the piece
				if(!chess_board[start_indexes[0]][start_indexes[1]].isValid(start_indexes,destination_indexes) || occupy == true) {
					System.out.println("Illegal move, try again");
				}
				//if valid move, set to white's move
				else{
					check = true;
				}
			}
		}

	}

}
