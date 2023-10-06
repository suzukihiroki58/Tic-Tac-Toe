package model;

import java.util.Scanner;

public class TicTacToe {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		char[][] gameBoard = { { '_', '|', '_', '|', '_' }, { '_', '|', '_', '|', '_' }, { ' ', '|', ' ', '|', ' ' } };
		Board.printBoard(gameBoard);
		boolean gameOver = false;
		boolean playAgain = true;

		while (playAgain) {
			while (!gameOver) {
				HumanPlayer.selectCell(gameBoard);
				gameOver = checkWinner(gameBoard);
				if (gameOver) {
					break;
				}

				CPUPlayer.selectCellAutomatically(gameBoard);
				gameOver = checkWinner(gameBoard);
				if (gameOver) {
					break;
				}
			}

			System.out.println("もう1度プレイしますか? はい / いいえ");
			input.nextLine();
			String result = input.nextLine();

			switch (result) {
			case "はい":
				playAgain = true;
				resetBoard(gameBoard);
				gameOver = false;
				Board.printBoard(gameBoard);
				break;

			case "いいえ":
				System.out.println("ありがとうございました");
				playAgain = false;
				break;
			default:
				break;
			}
		}
	}

	public static boolean checkWinner(char[][] gameboard) {

		if (gameboard[0][0] == 'X' && gameboard[0][2] == 'X' && gameboard[0][4] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][0] == 'O' && gameboard[0][2] == 'O' && gameboard[0][4] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}
		if (gameboard[1][0] == 'X' && gameboard[1][2] == 'X' && gameboard[1][4] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[1][0] == 'O' && gameboard[1][2] == 'O' && gameboard[1][4] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}
		if (gameboard[2][0] == 'X' && gameboard[2][2] == 'X' && gameboard[2][4] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[2][0] == 'O' && gameboard[2][2] == 'O' && gameboard[2][4] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][0] == 'X' && gameboard[1][0] == 'X' && gameboard[2][0] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][0] == 'O' && gameboard[1][0] == 'O' && gameboard[2][0] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][2] == 'X' && gameboard[1][2] == 'X' && gameboard[2][2] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][2] == 'O' && gameboard[1][2] == 'O' && gameboard[2][2] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][4] == 'X' && gameboard[1][4] == 'X' && gameboard[2][4] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][4] == 'O' && gameboard[1][4] == 'O' && gameboard[2][4] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][0] == 'X' && gameboard[1][2] == 'X' && gameboard[2][4] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][0] == 'O' && gameboard[1][2] == 'O' && gameboard[2][4] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[2][0] == 'X' && gameboard[1][2] == 'X' && gameboard[0][4] == 'X') {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[2][0] == 'O' && gameboard[1][2] == 'O' && gameboard[0][4] == 'O') {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (Board.isBoardFull(gameboard)) {
			System.out.println("引き分けです");
			return true;
		}

		return false;
	}

	public static void resetBoard(char[][] gameBoard) {
		gameBoard[0][0] = '_';
		gameBoard[0][2] = '_';
		gameBoard[0][4] = '_';
		gameBoard[1][0] = '_';
		gameBoard[1][2] = '_';
		gameBoard[1][4] = '_';
		gameBoard[2][0] = ' ';
		gameBoard[2][2] = ' ';
		gameBoard[2][4] = ' ';
	}
}
