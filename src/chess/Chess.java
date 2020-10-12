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
	
	public Chess[][] chess_board = new Chess[8][8];
	
	public Chess() {
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
		
		chess_board[7][0] = new Rook("bR", "white");
		chess_board[7][1] = new Knight("bN", "white");
		chess_board[7][2] = new Bishop("bB", "white");
		chess_board[7][3] = new Queen("bQ", "white");
		chess_board[7][4] = new King("bK", "white");
		chess_board[7][5] = new Bishop("bB", "white");
		chess_board[7][6] = new Knight("bN", "white");
		chess_board[7][7] = new Rook("bR", "white");
		chess_board[6][0] = new Pawn("bp", "white");
		chess_board[6][1] = new Pawn("bp", "white");
		chess_board[6][2] = new Pawn("bp", "white");
		chess_board[6][3] = new Pawn("bp", "white");
		chess_board[6][4] = new Pawn("bp", "white");
		chess_board[6][5] = new Pawn("bp", "white");
		chess_board[6][6] = new Pawn("bp", "white");
		chess_board[6][7] = new Pawn("bp", "white");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chess myBoard = new Chess();
		while(true) {
			//print the board
		}

	}

}
