package model;

public class HumanPlayer extends BasePlayer {
	public static void selectCell(char[][] gameBoard) {
		System.out.println("1〜9の好きな場所を入力してください");
		int move = TicTacToe.input.nextInt();
		boolean result = Board.isCellEmpty(move, gameBoard);
		while (!result) {
			System.out.println("そこには置けません");
			move = TicTacToe.input.nextInt();
			result = Board.isCellEmpty(move, gameBoard);
		}
		Board.placeSymbol(move, "human", gameBoard);
	}
}
