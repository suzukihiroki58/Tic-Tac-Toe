package model;

import java.util.Random;

public class CPUPlayer extends BasePlayer {
	public static void selectCellAutomatically(char[][] gameBoard, String firstPlayer) {
		Random rand = new Random();
		int move = rand.nextInt(9) + 1;

		boolean result = Board.isCellEmpty(move, gameBoard);

		while (!result) {
			move = rand.nextInt(9) + 1;
			result = Board.isCellEmpty(move, gameBoard);
		}

		System.out.println("CPUは" + move + "に置きました");
		Board.placeSymbol(move, "cpu", gameBoard, firstPlayer);
	}
}
