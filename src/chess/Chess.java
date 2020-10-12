package chess;

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
	
	public static void printBoard() {
		for(int i=0; i<chess_board.length; i++) {
			System.out.println();
			for(int j=0; j<chess_board[0].length; j++) {
				System.out.print(chess_board[i][j].getId() + " ");
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initBoard();
		printBoard();
		

	}

}
