package model;

public class HumanPlayer extends BasePlayer {
	public void selectCell(int i, int j, char symbol, char[][] board) {
		board[i][j] = symbol;
	}
}
