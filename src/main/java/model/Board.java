package model;

public class Board {
	private char[][] board;

	public Board() {
		this.board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public char[][] getBoard() {
		return this.board;
	}
}
