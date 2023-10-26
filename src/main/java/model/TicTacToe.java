package model;

public class TicTacToe {
	private String firstPlayer = null;
	private String secondPlayer = null;
	private Board board;
	private String currentPlayer;

	public TicTacToe() {
		this.board = new Board();
	}

	public void decideTurnRandomly() {
		if (Math.random() < 0.5) {
			firstPlayer = "Human";
			secondPlayer = "CPU";
		} else {
			firstPlayer = "CPU";
			secondPlayer = "Human";
		}
		currentPlayer = firstPlayer;
	}

	public String getFirstPlayer() {
		return firstPlayer;
	}

	public String getSecondPlayer() {
		return secondPlayer;
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void switchTurn() {
		currentPlayer = currentPlayer.equals(firstPlayer) ? secondPlayer : firstPlayer;
	}

	public char[][] getBoard() {
		return board.getBoard();
	}

	public String checkWinner() {
		char[][] currentBoard = board.getBoard();
		for (int i = 0; i < 3; i++) {
			if (currentBoard[i][0] != ' ' && currentBoard[i][0] == currentBoard[i][1]
					&& currentBoard[i][1] == currentBoard[i][2]) {
				return currentBoard[i][0] == 'O' ? firstPlayer : secondPlayer;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (currentBoard[0][i] != ' ' && currentBoard[0][i] == currentBoard[1][i]
					&& currentBoard[1][i] == currentBoard[2][i]) {
				return currentBoard[0][i] == 'O' ? firstPlayer : secondPlayer;
			}
		}

		if (currentBoard[0][0] != ' ' && currentBoard[0][0] == currentBoard[1][1]
				&& currentBoard[1][1] == currentBoard[2][2]) {
			return currentBoard[0][0] == 'O' ? firstPlayer : secondPlayer;
		}

		if (currentBoard[0][2] != ' ' && currentBoard[0][2] == currentBoard[1][1]
				&& currentBoard[1][1] == currentBoard[2][0]) {
			return currentBoard[0][2] == 'O' ? firstPlayer : secondPlayer;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (currentBoard[i][j] == ' ') {
					return null;
				}
			}
		}
		return "引き分け";

	}
}
