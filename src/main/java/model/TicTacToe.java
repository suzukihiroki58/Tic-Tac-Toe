package model;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		char[][] gameBoard = { { '_', '|', '_', '|', '_' }, { '_', '|', '_', '|', '_' }, { ' ', '|', ' ', '|', ' ' } };
		Board.printBoard(gameBoard);
		boolean gameOver = false;
		boolean playAgain = true;
		Random rand = new Random();

		while (playAgain) {
			String firstPlayer = rand.nextBoolean() ? "human" : "cpu";

			while (!gameOver) {
				if ("human".equals(firstPlayer)) {
					HumanPlayer.selectCell(gameBoard, firstPlayer);
					gameOver = checkWinner(gameBoard, firstPlayer);
					if (gameOver) {
						break;
					}

					CPUPlayer.selectCellAutomatically(gameBoard, firstPlayer);
					gameOver = checkWinner(gameBoard, firstPlayer);
					if (gameOver) {
						break;
					}
				} else {
					CPUPlayer.selectCellAutomatically(gameBoard, firstPlayer);
					gameOver = checkWinner(gameBoard, firstPlayer);
					if (gameOver) {
						break;
					}

					HumanPlayer.selectCell(gameBoard, firstPlayer);
					gameOver = checkWinner(gameBoard, firstPlayer);
					if (gameOver) {
						break;
					}
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

	public static boolean checkWinner(char[][] gameboard, String firstPlayer) {
		char humanPlayer = 'O';
		char cpuPlayer = 'X';
		if (firstPlayer.equals("cpu")) {
			humanPlayer = 'X';
			cpuPlayer = 'O';
		}

		if (gameboard[0][0] == humanPlayer && gameboard[0][2] == humanPlayer && gameboard[0][4] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][0] == cpuPlayer && gameboard[0][2] == cpuPlayer && gameboard[0][4] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}
		if (gameboard[1][0] == humanPlayer && gameboard[1][2] == humanPlayer && gameboard[1][4] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[1][0] == cpuPlayer && gameboard[1][2] == cpuPlayer && gameboard[1][4] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}
		if (gameboard[2][0] == humanPlayer && gameboard[2][2] == humanPlayer && gameboard[2][4] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[2][0] == cpuPlayer && gameboard[2][2] == cpuPlayer && gameboard[2][4] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][0] == humanPlayer && gameboard[1][0] == humanPlayer && gameboard[2][0] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][0] == cpuPlayer && gameboard[1][0] == cpuPlayer && gameboard[2][0] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][2] == humanPlayer && gameboard[1][2] == humanPlayer && gameboard[2][2] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][2] == cpuPlayer && gameboard[1][2] == cpuPlayer && gameboard[2][2] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][4] == humanPlayer && gameboard[1][4] == humanPlayer && gameboard[2][4] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][4] == cpuPlayer && gameboard[1][4] == cpuPlayer && gameboard[2][4] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[0][0] == humanPlayer && gameboard[1][2] == humanPlayer && gameboard[2][4] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[0][0] == cpuPlayer && gameboard[1][2] == cpuPlayer && gameboard[2][4] == cpuPlayer) {
			System.out.println("CPUの勝ちです");
			return true;
		}

		if (gameboard[2][0] == humanPlayer && gameboard[1][2] == humanPlayer && gameboard[0][4] == humanPlayer) {
			System.out.println("あなたの勝ちです");
			return true;
		}
		if (gameboard[2][0] == cpuPlayer && gameboard[1][2] == cpuPlayer && gameboard[0][4] == cpuPlayer) {
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
