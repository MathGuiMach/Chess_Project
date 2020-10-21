package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Application {

	//HOW TO RUN ON GIT BASH
	//command1: cd /c/WorkSpaces/ws_Eclipse/chess_project/bin
	//command2: java application/Application
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessMatch.getCheckmate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch,captured);
				
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				if(chessMatch.getPromoted() != null) {
					System.out.println("Enter piece for promotion (Q,k,R,B)");
					String type = sc.nextLine();
					while(!type.equals("B") && !type.equals("k") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Invalid Value! Enter piece for promotion (Q,k,R,B)");
						type = sc.nextLine();
					}
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
		
	}

}
