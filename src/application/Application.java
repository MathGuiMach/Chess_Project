package application;

import chess.ChessMatch;

public class Application {

	//HOW TO RUN 
	//GIT BASH
	//command1: cd /c/WorkSpaces/ws_Eclipse/chess_project/bin
	//command2: java application/Application
	
	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		UI.printBoard(chessMatch.getPieces());
	}

}
