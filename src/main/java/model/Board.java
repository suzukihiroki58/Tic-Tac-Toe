package model;

public class Board {

	public static void placeSymbol(int position, String player, char[][] gameBoard, String firstPlayer) {

		char symbol = ' ';
		if (player.equals(firstPlayer)) {
			symbol = 'O';
		} else {
			symbol = 'X';
		}

		switch (position) {
		case 1:
			gameBoard[0][0] = symbol;
			printBoard(gameBoard);
			break;
		case 2:
			gameBoard[0][2] = symbol;
			printBoard(gameBoard);
			break;
		case 3:
			gameBoard[0][4] = symbol;
			printBoard(gameBoard);
			break;
		case 4:
			gameBoard[1][0] = symbol;
			printBoard(gameBoard);
			break;
		case 5:
			gameBoard[1][2] = symbol;
			printBoard(gameBoard);
			break;
		case 6:
			gameBoard[1][4] = symbol;
			printBoard(gameBoard);
			break;
		case 7:
			gameBoard[2][0] = symbol;
			printBoard(gameBoard);
			break;
		case 8:
			gameBoard[2][2] = symbol;
			printBoard(gameBoard);
			break;
		case 9:
			gameBoard[2][4] = symbol;
			printBoard(gameBoard);
			break;
		default:
			break;
		}
	}

	public static void printBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static boolean isCellEmpty(int move, char[][] gameboard) {

		switch (move) {
		case 1:
			if (gameboard[0][0] == '_') {
				return true;
			} else {
				return false;
			}
		case 2:
			if (gameboard[0][2] == '_') {
				return true;
			} else {
				return false;
			}
		case 3:
			if (gameboard[0][4] == '_') {
				return true;
			} else {
				return false;
			}

		case 4:
			if (gameboard[1][0] == '_') {
				return true;
			} else {
				return false;
			}
		case 5:
			if (gameboard[1][2] == '_') {
				return true;
			} else {
				return false;
			}
		case 6:
			if (gameboard[1][4] == '_') {
				return true;
			} else {
				return false;
			}
		case 7:
			if (gameboard[2][0] == ' ') {
				return true;
			} else {
				return false;
			}
		case 8:
			if (gameboard[2][2] == ' ') {
				return true;
			} else {
				return false;
			}
		case 9:
			if (gameboard[2][4] == ' ') {
				return true;
			} else {
				return false;
			}

		default:
			return false;
		}
	}

	public static boolean isBoardFull(char[][] gameboard) {
		if (gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] != '_' &&
				gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' '
				&& gameboard[2][4] != ' ') {
			return true;
		}
		return false;
	}
}
