package model;

public class CPUPlayer extends BasePlayer {
	public void selectCellAutomatically(char symbol, char[][] board) {
		int i, j;
		do {
			i = (int) (Math.random() * 3);
			j = (int) (Math.random() * 3);
		} while (board[i][j] != ' ');
		board[i][j] = symbol;
	}
}
