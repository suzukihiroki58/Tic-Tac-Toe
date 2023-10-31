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
		
		if (session == null) {
			session = request.getSession(true);
		}
		User loggedInUser = (User) session.getAttribute("user");
		if (loggedInUser != null) {
			request.setAttribute("loggedInUser", loggedInUser.getUserName());
		}

		TicTacToe game = new TicTacToe();
		game.decideTurnRandomly();
		session.setAttribute("game", game);

		if ("CPU".equals(game.getCurrentPlayer())) {
			CPUPlayer cpu = new CPUPlayer();
			char symbol = game.getFirstPlayer().equals("CPU") ? 'O' : 'X';
			cpu.selectCellAutomatically(symbol, game.getBoard());
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
		User loggedInUser = (User) session.getAttribute("user");

		if ("Human".equals(game.getCurrentPlayer())) {
			HumanPlayer human = new HumanPlayer();
			int i = Integer.parseInt(request.getParameter("row"));
			int j = Integer.parseInt(request.getParameter("col"));
			char symbol = game.getFirstPlayer().equals("Human") ? 'O' : 'X';
			if (game.getBoard()[i][j] == ' ') {
				human.selectCell(i, j, symbol, game.getBoard());
				String winner = game.checkWinner();
				if (winner != null) {
					request.setAttribute("winner", winner);
				} else {
					game.switchTurn();
				}
			}
		}

		if ("CPU".equals(game.getCurrentPlayer())) {
			CPUPlayer cpu = new CPUPlayer();
			char symbol = game.getFirstPlayer().equals("CPU") ? 'O' : 'X';
			cpu.selectCellAutomatically(symbol, game.getBoard());
			game.switchTurn();
		}

		String winner = game.checkWinner();

		GameRecord record = new GameRecord();
		record.setUserId(loggedInUser.getUserId());
		record.setTotalGames(1);

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
		request.setAttribute("firstPlayer", game.getFirstPlayer());
		request.setAttribute("secondPlayer", game.getSecondPlayer());
		request.setAttribute("currentPlayer", game.getCurrentPlayer());
		if (loggedInUser != null) {
			request.setAttribute("loggedInUser", loggedInUser.getUserName());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/tictactoe.jsp");
		rd.forward(request, response);
	}

}