package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GameRecordsDAO;
import model.CPUPlayer;
import model.GameRecord;
import model.HumanPlayer;
import model.TicTacToe;
import model.User;

@WebServlet("/TicTacToeServlet")
public class TicTacToeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null) {
			User loggedInUser = (User) session.getAttribute("user");
			if (loggedInUser != null) {
				String username = loggedInUser.getUserName();
				request.setAttribute("loggedInUser", username);
			}
		}

		TicTacToe game = new TicTacToe();
		CPUPlayer cpu = new CPUPlayer();
		char[][] board = game.getBoard();
		game.decideTurnRandomly();

		if (session == null) {
			session = request.getSession(true);
		}

		session.setAttribute("game", game);

		char symbol;
		if ("CPU".equals(game.getCurrentPlayer())) {
			symbol = game.getFirstPlayer().equals("CPU") ? 'O' : 'X';
			cpu.selectCellAutomatically(symbol, board);
			game.switchTurn();
		}

		request.setAttribute("firstPlayer", game.getFirstPlayer());
		request.setAttribute("secondPlayer", game.getSecondPlayer());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/tictactoe.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		HttpSession session = request.getSession(false);

		String replay = request.getParameter("replay");
		if ("true".equals(replay)) {
			doGet(request, response);
			return;
		}

		TicTacToe game = (TicTacToe) session.getAttribute("game");
		HumanPlayer human = new HumanPlayer();
		CPUPlayer cpu = new CPUPlayer();

		char[][] board = game.getBoard();

		char symbol;
		if ("Human".equals(game.getCurrentPlayer())) {
			int i = Integer.parseInt(request.getParameter("row"));
			int j = Integer.parseInt(request.getParameter("col"));
			symbol = game.getFirstPlayer().equals("Human") ? 'O' : 'X';
			if (board[i][j] == ' ') {
				human.selectCell(i, j, symbol, board);
				String winner = game.checkWinner();
				if (winner != null) {
					request.setAttribute("winner", winner);
				} else {
					game.switchTurn();
				}
			}
		}

		if ("CPU".equals(game.getCurrentPlayer())) {
			symbol = game.getFirstPlayer().equals("CPU") ? 'O' : 'X';
			cpu.selectCellAutomatically(symbol, board);
			game.switchTurn();
		}

		String winner = game.checkWinner();

		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser != null) {
			String username = loggedInUser.getUserName();
			request.setAttribute("loggedInUser", username);
		}

		GameRecord record = new GameRecord();
		record.setUserId(loggedInUser.getUserId());
		record.setTotalGames(1);

		int userId = loggedInUser.getUserId();
		System.out.println("UserIdは" + userId);

		if ("Human".equals(winner)) {
			record.setWins(1);
		} else if ("CPU".equals(winner)) {
			record.setLosses(1);
		} else if ("Draw".equals(winner)) {
			record.setDraws(1);
		}

		if (winner != null) {
			request.setAttribute("winner", winner);
			GameRecordsDAO dao = new GameRecordsDAO();
			dao.upsertGameRecords(record);
		}

		session.setAttribute("game", game);
		session.setAttribute("board", game.getBoard());
		request.setAttribute("firstPlayer", game.getFirstPlayer());
		request.setAttribute("secondPlayer", game.getSecondPlayer());
		request.setAttribute("currentPlayer", game.getCurrentPlayer());

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/tictactoe.jsp");
		rd.forward(request, response);
	}

}